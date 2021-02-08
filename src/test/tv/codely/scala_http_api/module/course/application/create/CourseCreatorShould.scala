package tv.codely.scala_http_api.module.course.application.create

import tv.codely.scala_http_api.module.course.CourseUnitTestCase
import tv.codely.scala_http_api.module.course.domain.CourseStub

final class CourseCreatorShould extends CourseUnitTestCase {
  private val creator = new CourseCreator(repository)

  "save a course" in {
    val course = CourseStub.random

    repositoryShouldSave(course)

    creator.create(course.id, course.title, course.description) shouldBe ()
  }
}
