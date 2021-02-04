package tv.codely.scala_http_api.module.course.domain

import tv.codely.scala_http_api.module.shared.domain.UuidStub

import java.util.UUID

object CourseIdStub {
  def apply(value: String): CourseId = CourseIdStub(UuidStub(value))

  def apply(value: UUID): CourseId = CourseId(value)

  def random: CourseId = CourseId(UuidStub.random)
}
