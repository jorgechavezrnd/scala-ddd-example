package tv.codely.scala_http_api.module.course.application.search

import tv.codely.scala_http_api.module.course.CourseUnitTestCase
import tv.codely.scala_http_api.module.course.domain.CourseStub

final class CoursesSearcherTest extends CourseUnitTestCase {
  private val searcher = new CoursesSearcher(repository)

  "Courses Searcher" should {
    "search all existing courses" in {
      val existingCourse        = CourseStub.random
      val anotherExistingCourse = CourseStub.random
      val existingCourses       = Seq(existingCourse, anotherExistingCourse)

      repositoryShouldSearchAll(existingCourses)

      searcher.all() should be(existingCourses)
    }
  }
}
