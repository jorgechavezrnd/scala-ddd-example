package tv.codely.scala_http_api.module.course.application.search

import tv.codely.scala_http_api.module.course.domain.{Course, CourseRepository}

final class CoursesSearcher(repository: CourseRepository) {
  def all(): Seq[Course] = repository.all()
}
