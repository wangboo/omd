package com.cdyhhd.omd.actor

import akka.actor.Actor
import akka.actor.ActorLogging
import org.apache.mina.core.session.IoSession
import com.cdyhhd.omd.gate.SessionHandler
import scala.collection.mutable.HashMap

class GateActor extends Actor with ActorLogging {
  
  val userMap: HashMap[Int, IoSession] = HashMap[Int, IoSession]()
  
  override def receive = {
    case (GateSingal.LOGIN, id: Int) => 
      log.debug("login success: " + id)
      handle_login(id)
    case (GateSingal.LOGOUT, id: Int) => handle_logout(id)
  }
  
  /**
   * 登录
   */
  def handle_login(id: Int) {
    val session: IoSession = SessionHandler.session(id)
    if(session == null) {
      log.error("login user({}), but cannt find IoSession", id)
      return
    }
    userMap += (id -> session)
  }
  
  /**
   * 登出
   */
  def handle_logout(id: Int) {
    userMap.remove(id)
  }
  
}

object GateSingal extends Enumeration {
  val LOGIN, LOGOUT = Value
}