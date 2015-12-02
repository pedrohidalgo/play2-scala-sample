package models

import play.api.libs.json.Json
import play.api.libs.json.Writes
import slick.driver.PostgresDriver.api._

case class CategoryDTO(var name: String, var description: String,
                       var parent: Option[Category])

class Category(tag: Tag) extends Table[(Long, String, String)](tag, "CATEGORY") {
  def id = column[Long]("ID", O.PrimaryKey) // This is the primary key column
  def name = column[String]("NAME")
  def description = column[String]("DESCRIPTION")
  def * = (id, name, description)

}

object Category {
  val categoryDTOWrites = new Writes[CategoryDTO] {
    def writes(categoryDTO: CategoryDTO) = Json.obj(
      "name" -> categoryDTO.name,
      "description" -> categoryDTO.description
    )
  }
}

