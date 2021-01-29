package tv.codely.scala_http_api.module.course.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}
import tv.codely.scala_http_api.module.course.domain.Course

object CourseJsValueMarshaller {
  def marshall(courses: Seq[Course]): JsArray = JsArray(
    courses
      .map(
        v =>
          JsObject(
            "id"   -> JsString(v.id.value.toString),
            "name" -> JsString(v.name.value)
        )
      )
      .toVector
  )
}
