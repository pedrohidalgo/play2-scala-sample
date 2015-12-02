package controllers

import models.Category
import models.CategoryDTO
import play.api.libs.json.Json
import play.api.mvc._

class CategoryRESTController extends Controller {
  implicit val categoryDTOWrites = Category.categoryDTOWrites;

  def index = Action {
    val categoryDTO = CategoryDTO("super category", "the super category you know", Option.empty)
    val json = Json.toJson(categoryDTO)
    Ok(json)
  }

}