package tv.codely.scala_http_api.module.course.application.search

import tv.codely.scala_http_api.module.course.CourseUnitTestCase
import tv.codely.scala_http_api.module.course.domain.CourseStub

final class CoursesSearcherShould extends CourseUnitTestCase {
  private val searcher = new CoursesSearcher(repository)

  "search all existing courses" in {
    val existingCourse        = CourseStub.random
    val anotherExistingCourse = CourseStub.random
    val existingCourses       = Seq(existingCourse, anotherExistingCourse)

    repositoryShouldSearchAll(existingCourses)

    searcher.all().futureValue should be(existingCourses)
  }
}
