import java.util.concurrent.TimeUnit

import Actors.MsgCounter
import Messages.RecurringMessage
import akka.actor.{Actor, Props, ActorSystem}
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object DemoApp {

  val system = ActorSystem("DemoApp")
  def main (args: Array[String]) {
    sendRecurringMessages
    Await.ready(system.whenTerminated, Duration(1, TimeUnit.MINUTES))
//    system shutdown
  }

  /*
    Actors.MsgCounter is the actor to which the Quartz Scheduler sends a message every 2 seconds
   */
  def sendRecurringMessages = {
    val actor = system.actorOf(Props[MsgCounter])
    val q = QuartzSchedulerExtension(system)
    q.schedule("EVERY2SECONDS",actor,RecurringMessage("ReccuringTester"))
//    Thread sleep 20000
  }
}


