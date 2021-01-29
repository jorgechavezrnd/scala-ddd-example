package tv.codely.scala_http_api.module.courses.infrastructure.dependency_injection

import tv.codely.scala_http_api.module.courses.application.create.CourseCreator
import tv.codely.scala_http_api.module.courses.application.search.CoursesSearcher
import tv.codely.scala_http_api.module.courses.infrastructure.repository.InMemoryCourseRepository

final class CourseModuleDependencyContainer {
  private val repository = new InMemoryCourseRepository

  val coursesSearcher = new CoursesSearcher(repository)
  val courseCreator   = new CourseCreator(repository)
}
