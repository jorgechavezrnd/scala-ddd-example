package tv.codely.scala_http_api.module.video.infrastructure.marshaller

import java.util.UUID

import spray.json.{DeserializationException, JsNumber, JsString, JsValue, JsonFormat, _}
import tv.codely.scala_http_api.module.shared.infrastructure.marshaller.UuidJsonFormatMarshaller._
import tv.codely.scala_http_api.module.video.domain._

object VideoAttributesJsonFormatMarshaller {
  implicit object VideoIdMarshaller extends JsonFormat[VideoId] {
    override def write(value: VideoId): JsValue = value.value.toJson

    override def read(value: JsValue): VideoId = VideoId(value.convertTo[UUID])
  }

  implicit object VideoTitleMarshaller extends JsonFormat[VideoTitle] {
    def write(value: VideoTitle): JsValue = JsString(value.value)

    def read(value: JsValue): VideoTitle = value match {
      case JsString(title) => VideoTitle(title)
      case _               => throw DeserializationException("Expected 1 string for VideoTitle")
    }
  }

  implicit object VideoDurationMarshaller extends JsonFormat[VideoDuration] {
    def write(value: VideoDuration): JsValue = JsNumber(value.value.toSeconds)

    def read(value: JsValue): VideoDuration = value match {
      case JsNumber(seconds) => VideoDuration(seconds)
      case _                 => throw DeserializationException("Expected 1 number for VideoDuration")
    }
  }

  implicit object VideoCategoryMarshaller extends JsonFormat[VideoCategory] {
    def write(value: VideoCategory): JsValue = JsString(value.toString)

    def read(value: JsValue): VideoCategory = value match {
      case JsString(category) => VideoCategory(category)
      case _                  => throw DeserializationException("Expected 1 string to VideoCategory")
    }
  }
}
