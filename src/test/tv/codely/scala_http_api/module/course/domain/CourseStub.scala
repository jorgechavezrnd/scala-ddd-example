package tv.codely.scala_http_api.module.course.domain

import tv.codely.scala_http_api.module.video.domain.SeqStub

object CourseStub {
  def apply(
      id: String = CourseIdStub.random.value.toString,
      title: String = CourseTitleStub.random.value,
      description: String = CourseDescriptionStub.random.value
  ): Course = Course(id, title, description)

  def random: Course = apply()

  def randomSeq: Seq[Course] = SeqStub.randomOf(apply())
}
