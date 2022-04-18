package app

import zio._
import zio.random._
import zio.console._
import java.io.IOException

object Hangman extends App{
  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, ExitCode] = (for{
    userName <- putStrLn("Welcome to Hangman Game...!") *> getUserName
    word <- chooseWord
    _ <- executeGameInLoop(State.initial(userName, word))
  }yield()).exitCode

  private def getUserName: ZIO[Console, IOException, Name] = {
    for{
      input <- getUserInput("Please enter your name: ")
      name <- Name.make(input) match {
        case Some(name) => ZIO.succeed(name)
        case None => putStrLn("Invalid input. Please Retry...") *> getUserName
      }
    } yield name
  }

  lazy val chooseWord: ZIO[Random, Nothing, Word] = for {
    index <- nextIntBounded(dictionary.length)
    word <- ZIO.fromOption(dictionary.lift(index).flatMap(Word.make)).orDieWith(_ => new Error("Something wrong!"))
  } yield word

  private def executeGameInLoop(oldState: State): ZIO[Console, IOException, Unit] ={
    for{
      guess <- renderState(oldState) *> getGuess
      newState = oldState.addGuess(guess)
      guessResult = analyseGuess(oldState, newState, guess)
      _ <- guessResult match {
        case GuessResult.Won =>
          putStrLn("Congratulations!!! You won...") *> renderState(newState)
        case GuessResult.Lost =>
          putStrLn(s"HANGMAN !!! Sorry ${oldState.name}, you lost. The word was: ${oldState.word}") *>
            renderState(newState)
        case GuessResult.Correct =>
          putStrLn("That's a Correct guess.") *> executeGameInLoop(newState)
        case GuessResult.Incorrect =>
          putStrLn("That's an Incorrect guess.") *> executeGameInLoop(newState)
        case GuessResult.Unchanged =>
          putStrLn("You have already taken that guess!") *> executeGameInLoop(newState)
      }
    }yield()
  }

  private def renderState(state: State): ZIO[Console, Nothing, Unit] = {

    val hangman = ZIO.fromOption(
      hangmanStages.lift(state.failuresCount)
    ).orDieWith(_ => new Error("Something went Wrong"))

    val word = state.word.toList.map(c => if(state.guesses.map(_.char).contains(c)) s" $c " else "   ").mkString

    val line = List.fill(state.word.length)(" - ").mkString

    val guesses = s"Guesses: ${state.guesses.map(_.char.toLower).mkString(", ")}"

    hangman.flatMap(hangmanPattern =>
      putStrLn(
        s"""
           |$hangmanPattern
           |
           |$word
           |$line
           |
           |$guesses
           |
           |""".stripMargin
      )
    )
  }

  private def getGuess: ZIO[Console, IOException, Guess] = {
    for{
      input <- getUserInput("What is your guess?")
      guess <- Guess.make(input) match {
        case Some(guess) => ZIO.succeed(guess)
        case None => putStrLn("Invalid Guess! Please Retry...") *> getGuess
      }
    }yield guess
  }

  private def analyseGuess(oldState: State, newState: State, guess: Guess) ={
    if(oldState.guesses.contains(guess)) GuessResult.Unchanged
    else if(newState.playerLost) GuessResult.Lost
    else if(newState.playerWon) GuessResult.Won
    else if(oldState.word.contains(guess.char)) GuessResult.Correct
    else GuessResult.Incorrect
  }

  private def getUserInput(message:String)={
    for{
      _ <- putStrLn(message)
      input <- getStrLn
    } yield input
  }
}
