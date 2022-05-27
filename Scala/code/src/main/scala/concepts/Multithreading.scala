package concepts

object Multithreading extends App {

  // creating thread:
  // using runnable interface
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("This statement is running in parallel")
  })

  //scala offers an easier syntax for same:
  val therad2 = new Thread(() => println("this is running in thread 2"))

  // starting a thread:
  aThread.start()
  therad2.start()

  // threads are unpredicatble as:

  val helloThread = new Thread(() => (1 to 100).foreach(_ => println("hello")))

  val byeThread = new Thread(() => (1 to 100).foreach(_ => println("bye")))

//  helloThread.start()
//  byeThread.start()

  // the hello and bye output here is completely unpredictable and varies from run to run.

  // this can be a serious problem in applications.
  // example:

  class BankAccount(var balance: Int){

    def withdraw(amount: Int) = balance = balance - amount

    def deposit(amount: Int) = balance = balance + amount

    override def toString: String = balance.toString
  }

  // open a bank account with initially 1000 balance
  val account = new BankAccount(1000)
  // employ the use of threads to deposit and withdraw money as:

  val withdrawThread = new Thread(() => (1 to 100).foreach(_ => account.withdraw(1000)))

  val depositThread = new Thread(() => (1 to 100).foreach(_ => account.deposit(1000)))

//  withdrawThread.start()
//  depositThread.start()

//  withdrawThread.join()
//  depositThread.join()

  println(account.balance)

  // as depicted above, the variable balance is not thread safe.
  // data inconsistency
  // race condition

  // solution is making the balance variable thread safe as:

  // approach 1: using thread synchronization:
  class BankAccountTS1(var balance: Int){

    def withdraw(amount: Int) = this.synchronized{ balance = balance - amount }

    def deposit(amount: Int) = this.synchronized{ balance = balance + amount }

    override def toString: String = balance.toString
  }

  val threadSafeAccount1 = new BankAccountTS1(1000)
  // employ the use of threads to deposit and withdraw money as:

  val withdrawFromTS1 = new Thread(() => (1 to 100).foreach(_ => threadSafeAccount1.withdraw(1000)))

  val depositToTS1 = new Thread(() => (1 to 100).foreach(_ => threadSafeAccount1.deposit(1000)))

//  withdrawFromTS1.start()
//  depositToTS1.start()

//  withdrawFromTS1.join()
//  depositToTS1.join()

  println("from ts1 account type: "+threadSafeAccount1.balance)

  // in scala, most often there is no need for creating and managing threads.
  // This can be taken care by using futures instead.

  // problems with standard thread model:

  // Problem1 : OOPS encapsulation is only valid under single threaded environment.
  // in the above example of thread unsafe bank account the OOP encapsulation is broken in multithreaded env.
  // this can be solved by synchronization/ locks (as shown above)
  // however, synchronisation and locks leads to more problems like- deadlocks, livelocks etc.

  // Problem 2 : Delegating something to a thread is pain.
  // extremely difficult to pass a message to a thread, after its started.
  // Example: when need to pass a runnable to the already running thread:
  var task: Runnable = null
  val runningThread: Thread = new Thread(() => {
    while(true){
      while(task == null){
        runningThread.synchronized{
          println("[Background] waiting for a task...")
          runningThread.wait()
        }
      }
      task.synchronized{
        println("[Background] task assigned...")
        task.run()
        task == null
      }
    }
  })

  def delegateToBackgroundThread(r: Runnable): Unit ={
    if(task == null)
      task = r

    runningThread.synchronized{
      runningThread.notify()
    }
  }

  runningThread.start()
  Thread.sleep(2000)
  delegateToBackgroundThread(() => println("Hello"))
  Thread.sleep(2000)
  delegateToBackgroundThread(() => println("GoodBye"))

  // Problem 3: Error handling in multithreaded environment is very problematic.
}
