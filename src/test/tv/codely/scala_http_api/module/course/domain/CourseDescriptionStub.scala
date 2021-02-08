package tv.codely.scala_http_api.module.course.domain

import tv.codely.scala_http_api.module.shared.domain.{IntStub, StringStub}

object CourseDescriptionStub {
  private val minimumChars = 1
  private val maximumChars = 250

  def apply(value: String): CourseDescription = CourseDescription(value)

  def random: CourseDescription = CourseDescription(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
