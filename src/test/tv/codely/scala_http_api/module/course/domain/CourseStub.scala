package tv.codely.scala_http_api.module.course.domain

object CourseStub {
  def apply(
      id: String = CourseIdStub.random.value.toString,
      title: String = CourseTitleStub.random.toString,
      description: String = CourseDescriptionStub.random.toString
  ): Course = Course(id, title, description)

  def random: Course = apply()
}
