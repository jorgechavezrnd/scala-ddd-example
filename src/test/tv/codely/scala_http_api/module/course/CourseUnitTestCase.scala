package tv.codely.scala_http_api.module.course

import tv.codely.scala_http_api.module.UnitTestCase
import tv.codely.scala_http_api.module.course.domain.{Course, CourseRepository}

protected[course] trait CourseUnitTestCase extends UnitTestCase {
  protected val repository: CourseRepository = mock[CourseRepository]

  protected def repositoryShouldSave(course: Course): Unit =
    (repository.save _)
      .expects(course)
      .returning(())

  protected def repositoryShouldSearchAll(courses: Seq[Course]): Unit =
    (repository.all _)
      .expects()
      .returning(courses)
}
