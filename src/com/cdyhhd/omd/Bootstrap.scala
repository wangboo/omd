package com.cdyhhd.omd

import akka.actor.ActorSystem
import akka.actor.Props
import com.cdyhhd.omd.game.HelloActor
import akka.actor.Terminated
import com.cdyhhd.omd.gate.GateServer

object Bootstrap extends App {
  
  val system = ActorSystem()
  // 网关
  val gateServer = new GateServer(system, 9000)
  gateServer.start
  
  val helloActor = system.actorOf(Props[HelloActor])
  helloActor ! "hello"
  
  Thread.sleep(2000)
  system.terminate()
  
}