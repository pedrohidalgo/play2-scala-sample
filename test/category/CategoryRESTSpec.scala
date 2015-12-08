package category

import play.api.test._
import models.Category
import models.CategoryDTO
import play.api.Logger
import play.api.libs.json.JsArray
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.mvc.Http.MimeTypes.JSON

object CategoryRESTSpec extends PlaySpecification {

    "Category REST API Test" should {

        "GET Categories" in new WithApplication(FakeApplication()) {
            val Some(result) = route(FakeRequest(GET, "/categories"))

            status(result) must equalTo(OK)
            contentType(result) must beSome(JSON)
            charset(result) must beSome("utf-8")

            Logger.debug("result: " + contentAsString(result))
            val jsonResult = contentAsJson(result)

            val size = jsonResult.as[JsArray].value.size

            size must beGreaterThan(0)
        }

        "SAVE Category" in new WithApplication(FakeApplication()) {
            implicit val categoryReads = Category.categoryReads

            val catName = "anewname"
            val catDescription = "anewdescription"
            val body = Json.obj("name" -> catName, "description" -> catDescription)

            val Some(result) = route(FakeRequest(POST, "/categories").withJsonBody(body))

            status(result) must equalTo(OK)
            contentType(result) must beSome(JSON)
            charset(result) must beSome("utf-8")

            Logger.debug("result save category: " + contentAsString(result))
            val jsonResult = contentAsJson(result)

            val resultValue = (jsonResult \ "result").as[String]
            resultValue must equalTo("OK")
            
            val category = (jsonResult \ "category").as[CategoryDTO]
            category.name must beEqualTo(catName)
            category.description must beEqualTo(catDescription)
        }
    }
}