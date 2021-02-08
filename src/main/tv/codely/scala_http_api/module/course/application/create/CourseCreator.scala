package tv.codely.scala_http_api.module.course.application.create

import tv.codely.scala_http_api.module.course.domain._

final class CourseCreator(repository: CourseRepository) {
  def create(id: CourseId, title: CourseTitle, description: CourseDescription): Unit = {
    val course = Course(id, title, description)

    repository.save(course)
  }
}
