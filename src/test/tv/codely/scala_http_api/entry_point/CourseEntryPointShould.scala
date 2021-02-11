package tv.codely.scala_http_api.entry_point

import doobie.implicits._
import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import spray.json._
import tv.codely.scala_http_api.module.course.domain.CourseStub
import tv.codely.scala_http_api.module.course.infrastructure.marshaller.CourseJsValueMarshaller

final class CourseEntryPointShould extends AcceptanceSpec {
  private def cleanCoursesTable() =
    sql"TRUNCATE TABLE courses".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  "save a course" in posting(
    "/courses",
    """
      |{
      |  "id": "88678f6d-df40-4d69-9dcb-b87944f212b2",
      |  "title": "🚀 DDD en Scala",
      |  "description": "Curso donde se aplicaca DDD con Arquitectura Hexagonal en Scala"
      |}
      |""".stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }

  "return all the courses" in {
    cleanCoursesTable()

    val courses = CourseStub.randomSeq

    courses.foreach(c => courseDependencies.repository.save(c).futureValue)

    getting("/courses") {
      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe CourseJsValueMarshaller.marshall(courses)
    }
  }
}
