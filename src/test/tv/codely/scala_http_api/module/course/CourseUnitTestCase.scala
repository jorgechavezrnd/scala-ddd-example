package tv.codely.scala_http_api.module.course

import tv.codely.scala_http_api.module.UnitTestCase
import tv.codely.scala_http_api.module.course.domain.{Course, CourseRepository}

import scala.concurrent.Future

protected[course] trait CourseUnitTestCase extends UnitTestCase {
  // @ToDo: Use multiple inheritance in test suites extending from UnitTestCase and this CourseUnitTestCase
  // in order to make more explicit what we have and avoid making the UnitTestCase extending from MockFactory
  protected val repository: CourseRepository = mock[CourseRepository]

  protected def repositoryShouldSave(course: Course): Unit =
    (repository.save _)
      .expects(course)
      .returning(Future.unit)

  protected def repositoryShouldSearchAll(courses: Seq[Course]): Unit =
    (repository.all _)
      .expects()
      .returning(Future.successful(courses))
}
