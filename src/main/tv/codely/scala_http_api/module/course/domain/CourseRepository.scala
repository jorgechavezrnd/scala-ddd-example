package tv.codely.scala_http_api.module.course.domain

trait CourseRepository {
  def all(): Seq[Course]

  def save(course: Course): Unit
}
