package tv.codely.scala_http_api.module.course.infrastructure.repository

import tv.codely.scala_http_api.module.course.domain.{Course, CourseRepository}

final class InMemoryCourseRepository extends CourseRepository {
  private var courses: Seq[Course] = Seq[Course]()

  def all(): Seq[Course] = courses

  def save(course: Course): Unit = courses = courses :+ course
}
