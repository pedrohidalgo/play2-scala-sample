package controllers

import models.Category
import models.CategoryDTO
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

    def save = Action { request =>
        val jsonBody = request.body.asJson
        
        val name = (jsonBody.get \ "name").as[String]
        val description = (jsonBody.get \ "description").as[String]
        
        val dto = new CategoryDTO(name, description)
        
        val categoryDTOInDB = CategoryService.save(dto)
            
        Ok(Json.obj("result" -> "OK", "category" -> Json.toJson(categoryDTOInDB)))
    }

}