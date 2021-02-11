package tv.codely.scala_http_api.module.course.domain

object CourseCreatedStub {
  def apply(
      id: CourseId = CourseIdStub.random,
      title: CourseTitle = CourseTitleStub.random,
      description: CourseDescription = CourseDescriptionStub.random
  ): CourseCreated = CourseCreated(id, title, description)

  def apply(course: Course): CourseCreated = apply(course.id, course.title, course.description)

  def random: CourseCreated = apply()
}
