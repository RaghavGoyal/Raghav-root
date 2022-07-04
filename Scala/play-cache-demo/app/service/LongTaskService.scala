package service

class LongTaskService {

  def fetchValuefor(key: String): String ={
    Thread.sleep(2000)
    s"$key " * 10
  }

}
