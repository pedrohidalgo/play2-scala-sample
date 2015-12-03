package category

import dao.CategoryEbeanDAOImpl
import org.specs2.mutable._
import play.api.Logger
import play.api.test.FakeApplication
import play.api.test.WithApplication

class CategoryIntegrationSpec extends Specification {

    val fakeApplication = FakeApplication()
    //TODO use DI
    val categoryDAO = new CategoryEbeanDAOImpl

    "Category Database Integration test" should {
        "Find All Test" in new WithApplication(fakeApplication) {
            val categories = categoryDAO.findAll
            
            Logger.debug("categories: "+categories)

            categories.size must beGreaterThan(0)
        }
    }
}