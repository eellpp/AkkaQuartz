import akka.actor.{Actor, Props, ActorSystem}
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension

object DemoApp {

  val system = ActorSystem("DemoApp")
  def main (args: Array[String]) {
    sendRecurringMessages
    system shutdown
  }

  /*
    MsgCounter is the actor to which the Quartz Scheduler sends a message every 2 seconds
   */
  def sendRecurringMessages = {
    val actor = system.actorOf(Props[MsgCounter])
    val q = QuartzSchedulerExtension(system)
    q.schedule("EVERY2SECONDS",actor,"RecurringMessageTester")
    Thread sleep 20000
  }
}

 class MsgCounter extends Actor {
   var counter = 0
    def receive = {
      case name: String => println(s"Got Message $counter from $name"); counter +=  1;
    }
  }
