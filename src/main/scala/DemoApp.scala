import java.util.concurrent.TimeUnit

import Actors.MsgCounter
import Messages.RecurringMessage
import akka.actor.{ActorSystem, Props}
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension
import com.typesafe.config.ConfigFactory
import scala.collection.JavaConversions._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
object DemoApp {

  val system = ActorSystem("DemoApp")
  def main (args: Array[String]) {
      getScheduleNames().foreach(sendRecurringMessages(_))
      Await.ready(system.whenTerminated, Duration(1, TimeUnit.MINUTES))
  }

  def sendRecurringMessages(schedule: String) = {
    val actor = system.actorOf(Props[MsgCounter])
    QuartzSchedulerExtension(system)
      .schedule(schedule,actor,RecurringMessage("ReccuringTester"))
  }

  def getScheduleNames() = {
    val conf = ConfigFactory.load("quartz.conf")
    val schedules = conf.getConfig("akka.quartz.schedules").entrySet()
    schedules.map(schedule => schedule.getKey.split("\\.")(0)).toList.distinct
  }
}


