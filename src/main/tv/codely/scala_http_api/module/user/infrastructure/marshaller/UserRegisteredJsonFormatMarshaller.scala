package tv.codely.scala_http_api.module.user.infrastructure.marshaller

import spray.json.{DefaultJsonProtocol, DeserializationException, JsObject, JsString, JsValue, RootJsonFormat}
import tv.codely.scala_http_api.module.user.domain.UserRegistered
import UserAttributesJsonFormatMarshaller._
import spray.json._

object UserRegisteredJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit object UserRegisteredJsonFormat extends RootJsonFormat[UserRegistered] {
    override def write(ur: UserRegistered): JsValue = JsObject(
      "type" -> JsString(ur.`type`),
      "id"   -> ur.id.toJson,
      "name" -> ur.name.toJson
    )

    override def read(value: JsValue): UserRegistered =
      value.asJsObject.getFields("id", "name") match {
        case Seq(JsString(id), JsString(name)) => UserRegistered(id, name)
        case unknown                           => throw DeserializationException(s"Error reading VideoCreated JSON <$unknown>")
      }
  }
}
