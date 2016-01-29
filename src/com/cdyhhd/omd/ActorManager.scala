package com.cdyhhd.omd

import akka.actor.ActorSystem
import akka.actor.ActorRef
import com.cdyhhd.omd.actor.GateActor
import akka.actor.Props

object ActorManager {
  
  var system: ActorSystem = null
  var gateActor: ActorRef = null
  
  def init(system: ActorSystem) {
     ActorManager.system = system
     gateActor = system.actorOf(Props[GateActor])
  }
  
  
}