package misc

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import play.api.Logger
  
class HelloModule extends AbstractModule {
  def configure() = {
      Logger.info("come on here in the abstract module+++++++++++++++++++++++++++++++")
  }
}