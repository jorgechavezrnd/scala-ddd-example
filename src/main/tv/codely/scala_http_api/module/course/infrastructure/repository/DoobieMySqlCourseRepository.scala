package tv.codely.scala_http_api.module.course.infrastructure.repository

import doobie.implicits._
import tv.codely.scala_http_api.module.course.domain.{Course, CourseRepository}
import tv.codely.scala_http_api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import tv.codely.scala_http_api.module.shared.infrastructure.persistence.doobie.TypesConversions._

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMySqlCourseRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
    extends CourseRepository {
  override def all(): Future[Seq[Course]] =
    db.read(sql"SELECT course_id, title, description FROM courses".query[Course].to[Seq])

  override def save(course: Course): Future[Unit] =
    sql"INSERT INTO courses(course_id, title, description) VALUES (${course.id}, ${course.title}, ${course.description})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
}
