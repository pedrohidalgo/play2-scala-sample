package category

import dao.CategoryEbeanDAOImpl
import models.Category
import org.specs2.mutable._
import play.api.Logger
import play.api.test.FakeApplication
import play.api.test.WithApplication

class CategoryIntegrationSpec extends Specification {

    val fakeApplication = FakeApplication()
    //TODO use DI
    val categoryDAO = new CategoryEbeanDAOImpl

    "Category Database Integration test" should {
        "Find All Test" in new WithApplication(FakeApplication()) {
            val categories = categoryDAO.findAll
            
            Logger.debug("categories: "+categories)

            categories.size must beGreaterThan(0)
        }
        
        "Save Category Test" in new WithApplication(FakeApplication()) {
            val name = "aname"
            val category = new Category
            category.name = name
            category.description = "adescription"
            val categoryInDB = categoryDAO.save(category)
            
            categoryInDB.name must beEqualTo(name)
        }
    }
}