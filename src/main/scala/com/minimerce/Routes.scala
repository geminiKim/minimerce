package com.minimerce

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.minimerce.domain.deal.Deal
import com.minimerce.module.{Configuration, RepositoryModule}

import scala.util.{Failure, Success}

class Routes(modules: Configuration with RepositoryModule) {

  private val dealGetRoute = path("deals" / IntNumber) { (dealId) =>
    get {
      onComplete(
        (modules.dealRepository.findById(dealId)).mapTo[Option[Deal]]) {
        case Success(deal) => deal match {
          case Some(sup) => complete(OK, sup.name)
          case None => complete(NotFound, s"The supplier doesn't exist")
        }
        case Failure(ex) => complete(InternalServerError, s"An error occurred: ${ex.getMessage}")
      }
    }
  }
  val routes: Route = dealGetRoute
}

