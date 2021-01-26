package tv.codely.scala_http_api.video.infrastructure.stub

import tv.codely.scala_http_api.module.video.domain.VideoDuration
import tv.codely.scala_http_api.shared.infrastructure.stub.DurationStub

import scala.concurrent.duration.Duration

object VideoDurationStub {
  def apply(value: Duration): VideoDuration = VideoDuration(value)

  def random: VideoDuration = VideoDuration(DurationStub.random)
}
