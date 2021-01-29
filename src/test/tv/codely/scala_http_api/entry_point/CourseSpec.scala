package tv.codely.scala_http_api.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import spray.json._
import tv.codely.scala_http_api.module.course.infrastructure.marshaller.CourseJsValueMarshaller
import tv.codely.scala_http_api.module.course.infrastructure.stub.CourseStub

final class CourseSpec extends AcceptanceSpec {
  "save a course" in post(
    "/courses",
    """
      |{
      |  "id": "d40d2b8c-d23c-42c9-9b6d-8f6b9a7969d5",
      |  "name": "🚀 Productividad con Zsh"
      |}
      |""".stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }

  "return all the system courses" in get("/courses") {
    val expectedCourses = Seq(
      CourseStub(
        id = "d40d2b8c-d23c-42c9-9b6d-8f6b9a7969d5",
        name = "🚀 Productividad con Zsh"
      )
    )

    status shouldBe StatusCodes.OK
    contentType shouldBe ContentTypes.`application/json`
    entityAs[String].parseJson shouldBe CourseJsValueMarshaller.marshall(expectedCourses)
  }
}
