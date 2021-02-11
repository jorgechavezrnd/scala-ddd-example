package tv.codely.scala_http_api.module.course.domain

import tv.codely.scala_http_api.module.shared.domain.Message

object CourseCreated {
  def apply(id: String, title: String, description: String): CourseCreated = apply(
    CourseId(id),
    CourseTitle(title),
    CourseDescription(description)
  )

  def apply(course: Course): CourseCreated = apply(course.id, course.title, course.description)
}

final case class CourseCreated(
    id: CourseId,
    title: CourseTitle,
    description: CourseDescription
) extends Message {
  override val subType: String = "course_created"
}
