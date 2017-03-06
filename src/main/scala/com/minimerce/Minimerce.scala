package com.minimerce

import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.minimerce.module.{ActorModule, Configuration, PersistenceModule, RepositoryModule}

object Minimerce extends App {
  val modules = new Configuration  with ActorModule with PersistenceModule with RepositoryModule
  implicit val system = modules.system
  implicit val materializer = ActorMaterializer()
  implicit val ec = modules.system.dispatcher

  modules.initTable()
  val bindingFuture = Http().bindAndHandle(new Routes(modules).routes, "localhost", 9090)
  println(s"Server online at http://localhost:9090")
}
