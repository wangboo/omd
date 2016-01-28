package com.cdyhhd.omd.gate

import org.apache.mina.transport.socket.nio.NioSocketAcceptor
import akka.actor.ActorSystem

class GateServer(val system: ActorSystem, val port: Int) {
  
  val acceptor = new NioSocketAcceptor(4)
//  val handler = new ClientHandler(system)
//  acceptor.setHandler()
  
  def start {
    
  }
  
}

