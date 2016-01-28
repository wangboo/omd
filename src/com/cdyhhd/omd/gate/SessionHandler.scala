package com.cdyhhd.omd.gate

import org.apache.mina.core.service.IoHandlerAdapter
import akka.actor.ActorSystem
import akka.actor.ActorSystem
import org.apache.mina.core.session.IoSession
import org.apache.mina.core.session.IdleStatus
import com.cdyhhd.omd.game.GameActor
import akka.actor.Props

class SessionHandler(val system: ActorSystem) extends IoHandlerAdapter {
  
  override def sessionCreated(s: IoSession) {
    
    system.actorOf(Props[GameActor], "game_user")
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

object SessionHandler {
  
  val sessions: Map[Int, IoSession] = Map()
  var id = 0
  
  def generateId(s: IoSession) = synchronized {
    while(true) {
      id += 1
      if(!sessions.contains(id)) {
        sessions += (id -> s)
      }
    }
    
  }
  
  def releaseId = synchronized {
    
  }
  
}