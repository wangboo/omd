package com.cdyhhd.omd

import akka.actor.ActorSystem
import akka.actor.Props
import com.cdyhhd.omd.actor.HelloActor
import akka.actor.Terminated
import com.cdyhhd.omd.gate.GateServer
import org.slf4j.LoggerFactory
import akka.actor.ActorRef

object Bootstrap extends App {
  
  val log = LoggerFactory.getLogger(Bootstrap.getClass) 
  val system = ActorSystem()
  ActorManager.init(system)
  // 网关
//  val gateServer = new GateServer(system, 9000)
//  gateServer.start
  
  val helloActor = system.actorOf(Props[HelloActor])
  Range(1, 10).foreach(i => {
    log.debug("send hello")
    helloActor ! "hello"  
  })
  
  Thread.sleep(2000)
  system.terminate()
  
}