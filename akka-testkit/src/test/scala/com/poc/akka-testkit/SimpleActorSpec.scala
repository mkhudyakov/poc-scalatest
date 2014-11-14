package com.poc.`akka-testkit`

import akka.actor.{Actor, ActorSystem}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.{WordSpecLike, MustMatchers}

class SimpleActor extends Actor {

  /* Sample actor internal state */
  var lastMsg: String = ""

  def receive = {
    case msg: String => {
      /* Storing the message in the internal state variable */
      lastMsg = msg
      sender ! "Hello " + msg
    }
  }
}

class SimpleActorSpec extends TestKit(ActorSystem("testSystem"))
  with WordSpecLike
  with MustMatchers {

  /* Synchronous actor call and accessing underlying actor */
  "A simple actor" must {
    /* Creation of the TestActorRef */
    val actorRef = TestActorRef[SimpleActor]

    "receive messages" in {
      /* This call is synchronous. The actor receive() method will be called in the current thread */
      actorRef ! "world"
      /* With actorRef.underlyingActor, we can access the SimpleActor instance created by Akka */
      actorRef.underlyingActor.lastMsg must equal("world")
    }
  }
}

class ImplicitSenderTest extends TestKit(ActorSystem("testSystem"))
  // Using the ImplicitSender trait will automatically set `testActor` as the sender
  with ImplicitSender
  with WordSpecLike
  with MustMatchers {

  "A simple actor" must {
    "send back a result" in {
      // Creation of the TestActorRef
      val actorRef = TestActorRef[SimpleActor]
      actorRef ! "akka"
      // This method assert that the `testActor` has received a specific message
      expectMsg("Hello akka")
    }
  }
}
