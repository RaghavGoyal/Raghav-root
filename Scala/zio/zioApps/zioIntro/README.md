**Getting Started with ZIO.**

This repo is based on blog content https://www.baeldung.com/scala/zio-intro

ZIO is a zero dependency library for asynchronous and concurrent programming in Scala.

Prerequisites: <BR>
<ul>
    <li> Scala </li>
    <li> Monads in Scala </li>
    <li> Effect and Functional Effects </li>
</ul>

**Monads:**
Monads are a mechanism to sequence computations around the values augmented with additional features.
These Features are called **Effects**

For Example: <BR>
One of the features in Scala is the ability to manage the nullability of an object by means of Option[T].

Similarly, one of the features is to manage the asynchronicity, which is achieved by means of Future[T].

Both Option[T] and Future[T] are monadic constructs 
as they provide some additional features to the enclosed values.

Monads are characterised by the presence of both map and flatmap functions.
The presence of both these functions also enable 
for compression to be applied to such types.
<BR>
Since a monad has both map and flatmap functions,
the computations can be sequenced over these values such that
the output of one serves as the input to another.
<BR> <BR>
ZIO is a library that helps to model complex effects in an effectful program.

**Effect and Functional Effect:**<BR>
An effect is what the monad handles.
While effect is about doing something, functional effect
is about the description of doing something.
<BR>
For exapmle:<BR>
The Scala code - <BR>
`println(“Hello, Scala!”)` <BR>
is an effect that prints the “**Hello, Scala!**” message to the console.
The println function is of type Any => Unit.
It returns Unit, so it is a statement.

But in ZIO, <BR>
`Console.printLine(“Hello, ZIO!”)` <BR>
is a functional effect of printing “**Hello, ZIO!**” on the console. 
It is a description of such an operation.
Console.printLine is a function of type Any => ZIO[Any, IOException, Unit].
It returns the ZIO data type, which is the description of printing the message to the console.
<BR> <BR>
**More on effects and effectful programming:** https://alvinalexander.com/scala/what-effects-effectful-mean-in-functional-programming/
