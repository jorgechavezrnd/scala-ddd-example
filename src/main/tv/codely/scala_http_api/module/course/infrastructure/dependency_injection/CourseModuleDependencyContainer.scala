package tv.codely.scala_http_api.module.course.infrastructure.dependency_injection

import tv.codely.scala_http_api.module.course.application.create.CourseCreator
import tv.codely.scala_http_api.module.course.application.search.CoursesSearcher
import tv.codely.scala_http_api.module.course.infrastructure.repository.InMemoryCourseRepository

final class CourseModuleDependencyContainer {
  private val repository = new InMemoryCourseRepository

  val coursesSearcher = new CoursesSearcher(repository)
  val courseCreator   = new CourseCreator(repository)
}
