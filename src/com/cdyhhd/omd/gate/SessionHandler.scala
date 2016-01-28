package com.cdyhhd.omd.gate

import org.apache.mina.core.service.IoHandlerAdapter
import akka.actor.ActorSystem
import akka.actor.ActorSystem
import org.apache.mina.core.session.IoSession
import org.apache.mina.core.session.IdleStatus

class SessionHandler(val system: ActorSystem) extends IoHandlerAdapter {
  
  override def sessionCreated(s: IoSession) {
    
  }
  
  override def sessionOpened(s: IoSession) {
    
  }
  
  override def sessionClosed(s: IoSession) {
    
  }
  
  override def sessionIdle(s: IoSession, state: IdleStatus) {
    
  }
  
  override def exceptionCaught(s: IoSession, ex: Throwable) {
    
  }
  
  override def messageReceived(s: IoSession, msg: Any) {
    
  }
}