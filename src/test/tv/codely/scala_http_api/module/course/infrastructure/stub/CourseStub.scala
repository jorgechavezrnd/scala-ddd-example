package tv.codely.scala_http_api.module.course.infrastructure.stub

import tv.codely.scala_http_api.module.course.domain.Course

object CourseStub {
  def apply(
      id: String = CourseIdStub.random.value.toString,
      name: String = CourseNameStub.random.toString
  ): Course = Course(id, name)

  def random: Course = apply()
}
