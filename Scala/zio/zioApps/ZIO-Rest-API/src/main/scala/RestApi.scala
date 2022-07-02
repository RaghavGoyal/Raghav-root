import zhttp.http._
import zhttp.service.Server
import zio._

object RestApi extends zio.App {
  /**
   * ZHttp types:
   * 1.
   * Http[R, E, A, B]
   * The idea is:
   *  it takes input of type A,
   *  Http has encoding constraints.
   *  If the encoding constraints are met by A then we get a successful value of type B
   *  Otherwise, you get a failure of type E
   *  This can be visualised as:
   *  A => ZIO[R, Option[E], B]
   *  (taking an input and returning a zio type.)
   *
   *  2.
   *  HttpApp[R, E] => Http[R, E, Request, Response]
   *  (if there is a request and there exists a route that matches the request, you get a response,)
   */

  val ok = Http.ok
  val empty = Http.empty(Status.FORBIDDEN)
  val greet = Http.text("Welcome !")
  val fail = Http.fail(new RuntimeException("something wrong!"))
  val customErrorMsg = Http.text("Something wrong, Please Retry")

  val app = Http.collect[Request] {
    case Method.GET -> Root / "text" => Response.text("hello world")
    case Method.GET -> Root / "json" => Response.jsonString(
      """
        |{
        |  "greetings" : "Hello World"
        |}
        |""".stripMargin
    )
    case req @ Method.POST -> Root / "postData" =>
      val data = req.data
      val a = data.content
      val b = data.headers
      val c = data.productElementNames
      for(elem <- c){
        println(elem)
        if(elem == "content"){
          elem.
        }
      }
//      println(s"data in a $a,\n  in b: $b,\n in c $c")
      Response.ok
  }

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = Server.start(8090, app).exitCode
}
