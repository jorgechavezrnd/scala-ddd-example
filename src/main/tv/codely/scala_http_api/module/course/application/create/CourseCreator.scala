package tv.codely.scala_http_api.module.course.application.create

import tv.codely.scala_http_api.module.course.domain._
import tv.codely.scala_http_api.module.shared.domain.MessagePublisher

final class CourseCreator(repository: CourseRepository, publisher: MessagePublisher) {
  def create(id: CourseId, title: CourseTitle, description: CourseDescription): Unit = {
    val course = Course(id, title, description)

    repository.save(course)

    publisher.publish(CourseCreated(course))
  }
}
