package Ch2

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

/**
 * This class demonstrates how the akka configuration can be managed.
 */
object Configuration extends App {

  /**
   * There are different ways to manage the configuration for akka.
   * 1. Inline configuration.
   * 2. Default config file (application.conf)
   * 3. Separate config in application.conf file.
   * 4. Configuration from conf files (other than application.conf)
   * 5. Configurations in different formats like JSON, properties etc.
   */

//  1. Inline configuration.
   class SimpleLoggingActor extends Actor with ActorLogging {
    override def receive: Receive = {
      case msg => log.info(s"Logging msg: $msg")
    }
  }
  val configString =
    """
      | akka {
      |    loglevel = "DEBUG"
      | }
      |""".stripMargin

  val config: Config = ConfigFactory.parseString(configString)
  val system = ActorSystem("ConfigurationDemo", ConfigFactory.load(config))
  val actor = system.actorOf(Props[SimpleLoggingActor])
  actor ! "A logging message"

//  2. From application.conf
  val defaultConfigSystem = ActorSystem("defaultConfigSystem")   // No config needed
  val defaultConfigActor = defaultConfigSystem.actorOf(Props[SimpleLoggingActor])
  defaultConfigActor ! "Remember me"

//  3. Separate config in application.conf file.
  ActorSystem("specialConfigSystem", ConfigFactory.load().getConfig("specialConfig"))
    .actorOf(Props[SimpleLoggingActor]) ! "Special logging configuration"

//  4. Configuration from conf files (other than application.conf)
  val configFromOtherFile = ConfigFactory.load("temp/a.conf")
  println(configFromOtherFile.getString("akka.loglevel"))

//  5. Configurations in different formats like JSON, properties etc.

  val jsonConfig = ConfigFactory.load("json/jsonConfigFile.conf")
  println(s"json config: ${jsonConfig.getString("someProperty")}")
  println(s"json config: ${jsonConfig.getString("akka.loglevel")}")

  val propsConfig = ConfigFactory.load("properties/props.properties")
  println(s"props config: ${propsConfig.getString("my.simpleProperty")}")
  println(s"props config: ${propsConfig.getString("akka.loglevel")}")
}

// NEXT: Ch 3 - testing akka systems