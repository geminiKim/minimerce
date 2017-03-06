package com.minimerce.module

import akka.actor.ActorSystem


trait ActorModule {
  this: ConfigurationModule =>
  val system = ActorSystem("minimerce", config)
}