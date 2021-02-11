package tv.codely.scala_http_api.module.course.infrastructure.marshaller

import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import CourseAttributesJsonFormatMarshaller._
import tv.codely.scala_http_api.module.course.domain._

object CourseJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit val courseFormat: RootJsonFormat[Course] = jsonFormat3(
    Course.apply(_: CourseId, _: CourseTitle, _: CourseDescription)
  )
}
