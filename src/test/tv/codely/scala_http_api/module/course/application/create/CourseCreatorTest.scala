package tv.codely.scala_http_api.module.course.application.create

import tv.codely.scala_http_api.module.course.CourseUnitTestCase
import tv.codely.scala_http_api.module.course.domain.CourseStub

final class CourseCreatorTest extends CourseUnitTestCase {
  private val creator = new CourseCreator(repository)

  "Course Creator" should {
    "save a course" in {
      val course = CourseStub.random

      repositoryShouldSave(course)

      creator.create(course.id, course.title, course.description) should be(())
    }
  }
}
