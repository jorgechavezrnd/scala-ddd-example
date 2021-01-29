package tv.codely.scala_http_api.entry_point.controller.course

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.StandardRoute
import tv.codely.scala_http_api.module.course.application.create.CourseCreator
import akka.http.scaladsl.server.Directives._
import tv.codely.scala_http_api.module.course.domain.{CourseId, CourseName}

final class CoursePostController(creator: CourseCreator) {
  def post(id: String, name: String): StandardRoute = {
    creator.create(CourseId(id), CourseName(name))

    complete(HttpResponse(NoContent))
  }
}
