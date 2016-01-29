package com.cdyhhd.omd.game

import akka.actor.ActorLogging
import akka.actor.Actor

class GameActor extends Actor with ActorLogging {
  
  def receive = {
    case (id, msg) => println(id + ": msg" + msg) 
  }
  
}