package tv.codely.scala_http_api.module.courses.application.create

import tv.codely.scala_http_api.module.courses.domain.{Course, CourseId, CourseName, CourseRepository}

final class CourseCreator(repository: CourseRepository) {
  def create(id: CourseId, name: CourseName): Unit = {
    val course = Course(id, name)

    repository.save(course)
  }
}
