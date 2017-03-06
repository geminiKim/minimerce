package com.minimerce.module

import akka.actor.ActorSystem

trait ActorModule {
  this: Configuration =>
  val system = ActorSystem("minimerce", config)
}