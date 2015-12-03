package controllers

import models.Category
import play.api.libs.json.Json
import play.api.mvc._
import service.CategoryService

class CategoryRESTController extends Controller {
    implicit val categoryDTOWrites = Category.categoryWrites;

    def get = Action {
        val categoriesDTO = CategoryService.findAll
        val json = Json.toJson(categoriesDTO)
        Ok(json)
    }

}