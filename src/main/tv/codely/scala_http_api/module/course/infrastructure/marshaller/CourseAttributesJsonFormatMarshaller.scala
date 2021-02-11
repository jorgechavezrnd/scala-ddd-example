package tv.codely.scala_http_api.module.course.infrastructure.marshaller

import java.util.UUID

import spray.json.{DeserializationException, JsString, JsValue, JsonFormat, _}
import tv.codely.scala_http_api.module.shared.infrastructure.marshaller.UuidJsonFormatMarshaller._
import tv.codely.scala_http_api.module.course.domain._

object CourseAttributesJsonFormatMarshaller {
  implicit object CourseIdMarshaller extends JsonFormat[CourseId] {
    override def write(value: CourseId): JsValue = value.value.toJson

    override def read(value: JsValue): CourseId = CourseId(value.convertTo[UUID])
  }

  implicit object CourseTitleMarshaller extends JsonFormat[CourseTitle] {
    def write(value: CourseTitle): JsValue = JsString(value.value)

    def read(value: JsValue): CourseTitle = value match {
      case JsString(title) => CourseTitle(title)
      case _               => throw DeserializationException("Expected 1 string for CourseTitle")
    }
  }

  implicit object CourseDescriptionMarshaller extends JsonFormat[CourseDescription] {
    def write(value: CourseDescription): JsValue = JsString(value.value)

    def read(value: JsValue): CourseDescription = value match {
      case JsString(title) => CourseDescription(title)
      case _               => throw DeserializationException("Expected 1 string for CourseDescription")
    }
  }
}
