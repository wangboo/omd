package com.cdyhhd.omd.gate

import org.apache.mina.core.service.IoHandlerAdapter
import akka.actor.ActorSystem
import akka.actor.ActorSystem
import org.apache.mina.core.session.IoSession
import org.apache.mina.core.session.IdleStatus
import com.cdyhhd.omd.actor.GameActor
import akka.actor.Props
import java.util.HashMap

class SessionHandler(val system: ActorSystem) extends IoHandlerAdapter {
  
  override def sessionCreated(s: IoSession) {
    val id = SessionHandler.generateId(s) 
    val gameActor = system.actorOf(Props[GameActor], "game_user_" + id)
    s.setAttribute(SessionHandler.GAME_ACTOR_KEY, gameActor)
    s.setAttribute(SessionHandler.GAME_LOGIN_KEY, SessionLoginState.CREATE)
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
  
  val GAME_ACTOR_KEY = "game_actor_key"
  val GAME_LOGIN_KEY = "game_login"
  
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
  
  // 回收
  def release(id: Int) = synchronized {
    sessions.remove(id)
  }
  
  // 获取session
  def session(id: Int): IoSession = sessions.get(id)
  
  // 是否包含
  def contains(id: Int): Boolean = sessions.containsKey(id)
  
}

/**
 * 登录状态
 */
object SessionLoginState extends Enumeration {
  val CREATE, LOGINED = Value
}


