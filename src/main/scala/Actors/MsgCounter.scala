package Actors

import Messages.RecurringMessage
import akka.actor.Actor

class MsgCounter extends Actor {
  var counter = 0
   def receive = {
     case name:RecurringMessage => println(s"Got Message $counter from $name"); counter +=  1;
   }
 }
