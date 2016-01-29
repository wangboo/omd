package com.cdyhhd.omd.gate

import org.apache.mina.core.service.IoHandlerAdapter
import akka.actor.ActorSystem
import akka.actor.ActorSystem
import org.apache.mina.core.session.IoSession
import org.apache.mina.core.session.IdleStatus
import com.cdyhhd.omd.game.GameActor
import akka.actor.Props
import java.util.HashMap

class SessionHandler(val system: ActorSystem) extends IoHandlerAdapter {
  
  override def sessionCreated(s: IoSession) {
    val id = SessionHandler.generateId(s) 
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
  
  val sessions: HashMap[Int, IoSession] = new HashMap(1000)
  var id = 0
  
  def generateId(s: IoSession): Int = synchronized {
    while(true) {
      id += 1
      if(id == Int.MaxValue) {
        id = 0
      }
      if(!sessions.containsKey(id)) {
        sessions.put(id, s)
        return id 
      }
    }
    return -1
  }
  
  def release(id: Int) = synchronized {
    sessions.remove(id)
  }
  
}