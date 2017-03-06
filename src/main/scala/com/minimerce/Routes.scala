package com.minimerce

import akka.http.scaladsl.server.Route
import com.minimerce.module.{Configuration, PersistenceModule}

class Routes(modules: Configuration with PersistenceModule) {
  val routes: Route = null
}