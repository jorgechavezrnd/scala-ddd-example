package tv.codely.scala_http_api.module.video.application.create

import tv.codely.scala_http_api.module.video.VideoUnitTestCase
import tv.codely.scala_http_api.module.video.domain.VideoStub

final class VideoCreatorTest extends VideoUnitTestCase {
  private val creator = new VideoCreator(repository)

  "Video Creator" should {
    "save a video" in {
      val video = VideoStub.random

      repositoryShouldSave(video)

      creator.create(video.id, video.title, video.duration, video.category) should be(())
    }
  }
}
