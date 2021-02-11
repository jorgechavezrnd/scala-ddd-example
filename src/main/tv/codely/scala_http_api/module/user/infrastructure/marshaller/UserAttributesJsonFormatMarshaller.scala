package tv.codely.scala_http_api.module.user.infrastructure.marshaller

import java.util.UUID

import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat}
import tv.codely.scala_http_api.module.shared.infrastructure.marshaller.UuidJsonFormatMarshaller._
import tv.codely.scala_http_api.module.user.domain.{UserId, UserName}
import spray.json._

object UserAttributesJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit object UserIdMarshaller extends JsonFormat[UserId] {
    override def write(value: UserId): JsValue = value.value.toJson

    override def read(value: JsValue): UserId = UserId(value.convertTo[UUID])
  }

  implicit object UserNameMarshaller extends JsonFormat[UserName] {
    override def write(value: UserName): JsValue = JsString(value.value)

    override def read(value: JsValue): UserName = value match {
      case JsString(name) => UserName(name)
      case _              => throw DeserializationException("Expected 1 string for UserName")
    }
  }
}
