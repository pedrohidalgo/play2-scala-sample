import org.specs2.mutable._

class CategoryUnitTest extends Specification {

  "The 'Hello world' string" should {
    "contain 11 characters" in {
      "Hello world" must have size (11)
    }
  }

//  "Categories DB functionaly" should {
//    "can be saved" in {
//      "dfsd" 
//  }
//    }
}