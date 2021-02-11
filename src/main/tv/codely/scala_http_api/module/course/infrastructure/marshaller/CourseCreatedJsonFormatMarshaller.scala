package tv.codely.scala_http_api.module.course.infrastructure.marshaller

import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, RootJsonFormat}
import tv.codely.scala_http_api.module.course.domain._
import CourseAttributesJsonFormatMarshaller._
import spray.json._

object CourseCreatedJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit object CourseCreatedJsonFormat extends RootJsonFormat[CourseCreated] {
    override def write(c: CourseCreated): JsValue = JsObject(
      "type"        -> JsString(c.`type`),
      "id"          -> c.id.toJson,
      "title"       -> c.title.toJson,
      "description" -> c.description.toJson
    )

    override def read(value: JsValue): CourseCreated =
      value.asJsObject.getFields("id", "title", "description") match {
        case Seq(JsString(id), JsString(title), JsString(description)) =>
          CourseCreated(id, title, description)
        case unknown => throw DeserializationException(s"Error reading CourseCreated JSON <$unknown>")
      }
  }
}
