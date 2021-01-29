package tv.codely.scala_http_api.module.course.infrastructure.stub

import tv.codely.scala_http_api.module.course.domain.CourseId
import tv.codely.scala_http_api.module.shared.stub.UuidStub

import java.util.UUID

object CourseIdStub {
  def apply(value: String): CourseId = CourseIdStub(UuidStub(value))

  def apply(value: UUID): CourseId = CourseId(value)

  def random: CourseId = CourseId(UuidStub.random)
}
