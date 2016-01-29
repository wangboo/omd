package com.cdyhhd.omd

import akka.actor.ActorSystem
import akka.actor.Props
import com.cdyhhd.omd.game.HelloActor
import akka.actor.Terminated
import com.cdyhhd.omd.gate.GateServer
import org.slf4j.LoggerFactory
import akka.actor.ActorRef

object Bootstrap extends App {
  
  val log = LoggerFactory.getLogger(Bootstrap.getClass) 
  val system = ActorSystem()
  // 网关
//  val gateServer = new GateServer(system, 9000)
//  gateServer.start
  
  Range(1, 10).foreach(i => {
    val helloActor = system.actorOf(Props[HelloActor], "user_"+i)
    log.debug("send hello")
    helloActor ! "hello"  
  })
  
  Thread.sleep(2000)
  system.terminate()
  
}