package service

import models.Category
import models.CategoryDTO
import slick.lifted.TableQuery

object CategoryService {

  val categories = TableQuery[Category]

  def save(dto: CategoryDTO) = {
    println("Categories:")
    //        categories.for
//    db.run(categories.result).map(_.foreach {
//      case (name) =>
//        println("name: " + name)
//    })
//    val result = categories.sortBy(_.name)
  }
  
//  def findAll() = {
//    
//  }

}
