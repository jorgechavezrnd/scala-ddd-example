package tv.codely.scala_http_api.module.courses.application.search

import tv.codely.scala_http_api.module.courses.domain.{Course, CourseRepository}

final class CoursesSearcher(repository: CourseRepository) {
  def all(): Seq[Course] = repository.all()
}
