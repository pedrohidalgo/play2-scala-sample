package controllers

import play.api.mvc.Action
import play.api.mvc.Controller

class MainController extends Controller {
  def index = Action {
    //    val categories = TableQuery[Category]
    //    dbService.db.run(categories.result).map(_.foreach {
    //      case (name) =>
    //        println("  " + name + "\t")
    //    })
//    val db = Database.forConfig("postgres")

//    val action = sql"select NAME from CATEGORY".as[String]
//    dbService.dbConfig.db.run(action)
    Ok("Your dddd you know what I'm dfsdftalking about new application is ready.")
  }
  
}
