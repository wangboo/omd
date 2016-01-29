package com.cdyhhd.omd.actor

import akka.actor.ActorLogging
import akka.actor.Actor

class HelloActor extends Actor with ActorLogging {
  
  def receive = {
    case "hello" => log.debug("recv test " + this)
    case aa => log.debug("recv unknown {}", aa)
  }
  
}