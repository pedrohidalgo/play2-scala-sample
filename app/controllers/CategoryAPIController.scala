package controllers

import play.api.mvc.Action
import play.api.mvc.Controller
import models.CategoryDTO
import service.CategoryService

class CategoryAPIController extends Controller {

  def save = Action { 
//    val dto = new CategoryDTO("comeon", Option.empty)
//    CategoryService.save(dto);
    Ok("it is not implemented yet")
  }

}
