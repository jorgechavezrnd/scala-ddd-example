package tv.codely

import tv.codely.backoffice.api.BackofficeApiApp
import tv.codely.backoffice.consumer.BackofficeConsumerApp
import tv.codely.mooc.api.MoocApiApp
import tv.codely.mooc.consumer.MoocConsumerApp

object Launcher {
  private val MoocApiArgument       = "mooc-api"
  private val MoocConsumersArgument = "mooc-consumers"

  private val BackOfficeApiArgument       = "backoffice-api"
  private val BackofficeConsumersArgument = "backoffice-consumers"

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      throw new RuntimeException("You need to specify which app to start")
    }

    args(0) match {
      case MoocApiArgument       => MoocApiApp.start()
      case MoocConsumersArgument => MoocConsumerApp.start()

      case BackOfficeApiArgument       => BackofficeApiApp.start()
      case BackofficeConsumersArgument => BackofficeConsumerApp.start()

      case _ => println("Application doesn't exist!")
    }
  }
}
