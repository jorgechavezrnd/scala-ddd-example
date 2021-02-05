package tv.codely.scala_http_api.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import spray.json._
import tv.codely.scala_http_api.module.course.domain.CourseStub
import tv.codely.scala_http_api.module.course.infrastructure.marshaller.CourseJsValueMarshaller

final class CourseSpec extends AcceptanceSpec {
  "save a course" in post(
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

  "return all the system courses" in get("/courses") {
    val expectedCourses = Seq(
      CourseStub(
        id = "88678f6d-df40-4d69-9dcb-b87944f212b2",
        title = "🚀 DDD en Scala",
        description = "Curso donde se aplicaca DDD con Arquitectura Hexagonal en Scala"
      )
    )

    status shouldBe StatusCodes.OK
    contentType shouldBe ContentTypes.`application/json`
    entityAs[String].parseJson shouldBe CourseJsValueMarshaller.marshall(expectedCourses)
  }
}
