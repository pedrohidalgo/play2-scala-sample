package category

import play.api.test._
import play.api.Logger
import play.api.test.Helpers._
import play.mvc.Http.MimeTypes.JSON

object CategoryRESTSpec extends PlaySpecification {
  val myPublicAddress = "localhost:9000"

  "The specification" should {

    val fakeApplication = FakeApplication()

    "respond to the index Action" in new WithApplication(fakeApplication) {
      val Some(result) = route(FakeRequest(GET, "/categories"))

      Logger.debug("result: "+contentAsString(result))
      status(result) must equalTo(OK)
      contentType(result) must beSome(JSON)
      charset(result) must beSome("utf-8")
    }
  }
}