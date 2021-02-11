package tv.codely.scala_http_api.module.course.infrastructure.repository

import tv.codely.scala_http_api.module.course.CourseIntegrationTestCase
import doobie.implicits._
import tv.codely.scala_http_api.module.course.domain.CourseStub

final class DoobieMySqlCourseRepositoryShould extends CourseIntegrationTestCase {
  private def cleanCoursesTable() =
    sql"TRUNCATE TABLE courses".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  "return an empty sequence if there're no courses" in {
    cleanCoursesTable()

    repository.all().futureValue shouldBe Seq.empty
  }

  "search all existing courses" in {
    cleanCoursesTable()

    val courses = CourseStub.randomSeq

    courses.foreach(c => repository.save(c).futureValue)

    repository.all().futureValue shouldBe courses
  }
}
