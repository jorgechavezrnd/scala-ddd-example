package tv.codely.scala_http_api.entry_point.controller.user

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import tv.codely.scala_http_api.module.user.application.register.UserRegisterer
import tv.codely.scala_http_api.module.user.domain.{UserId, UserName}

final class UserPostController(registerer: UserRegisterer) {
  def post(id: String, name: String): StandardRoute = {
    registerer.register(UserId(id), UserName(name))

    complete(HttpResponse(NoContent))
  }
}
