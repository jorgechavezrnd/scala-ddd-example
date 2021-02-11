package tv.codely.scala_http_api.module.course.domain

object Course {
  def apply(id: String, title: String, description: String): Course = Course(
    CourseId(id),
    CourseTitle(title),
    CourseDescription(description)
  )
}

case class Course(id: CourseId, title: CourseTitle, description: CourseDescription)
