package com.cdyhhd.omd.game

import akka.actor.ActorLogging
import akka.actor.Actor

class HelloActor extends Actor with ActorLogging {
  
  def receive = {
    case "test" => log.debug("recv test")
    case aa => log.debug("recv unknown {}", aa)
  }
  
}