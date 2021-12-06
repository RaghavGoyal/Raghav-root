package Ch1

object Multithreading extends App {
//  Conventional way of creating a thread; implementing a runnable interface and overriding the run method.
  val thread1 = new Thread(new Runnable {
    override def run(): Unit = println("This statement is running in a separate thread 1")
  })

//  this is a syntactical sugar for above in scala
  val thread2 = new Thread(() => println("This statement is running in a separate thread 2"))

//  starting a thread:
  thread1.run()
  thread2.run()

//  wait for thread to finish:
  thread2.join()

//  Synchronization problem in thread:
  val threadHello = new Thread(() => (1 to 100).foreach( _ => println("Hello")))
  val threadBye = new Thread(() => (1 to 100).foreach( _ => println("Bye")))

  threadHello.start()
  threadBye.start()
//  since both the threads have started, they are running in parallel now;
//  hence the output is not predictable in this case; as it depends on how the OS schedules the tasks.

// more example of synchronization issues:
  class Account(private var amount: Int){
//  this withdraw method is thread unsafe as it may be accessed and manipulated by multiple threads simultaneously
    def withdraw(money: Int) = this.amount -= money

//    This method is thread safe as amount now will be accessed by single thread at any point of execution
    def safeWithdraw(money: Int) = this.synchronized{
      this.amount -= money
    }

//  another method to make the amount variable thread safe is-
//  use @volatile annotation before the amount in class signature.

  }

}
