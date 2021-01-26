package tv.codely.scala_http_api.video.infrastructure.stub

import tv.codely.scala_http_api.module.video.domain.VideoId

import java.util.UUID
import tv.codely.scala_http_api.shared.infrastructure.stub.UuidStub

object VideoIdStub {
  def apply(value: String): VideoId = VideoIdStub(UuidStub(value))

  def apply(value: UUID): VideoId = VideoId(value)

  def random: VideoId = VideoId(UuidStub.random)
}
