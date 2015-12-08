package models

import com.avaje.ebean.Model
import javax.persistence._

case class CategoryDTO(id: Long, name: String, description: String) {
    def this(name: String, description: String) = this(0, name, description)
}

@Entity
class Category extends Model {
    @Id
    var id: Long = 0
    @Column(nullable = false)
    var name: String = null
    var description: String = null

    override def toString() = {
        "id: " + id + " name: " + name + " description: " + description
    }

}

object Category {
    import play.api.libs.json._
    import play.api.libs.json.Reads._
    import play.api.libs.functional.syntax._
    
    val find = new Model.Finder[Long, Category](classOf[Category])

    val categoryWrites = new Writes[CategoryDTO] {
        def writes(category: CategoryDTO) = Json.obj(
            "id" -> category.id,
            "name" -> category.name,
            "description" -> category.description
        )
    }

    val categoryReads: Reads[CategoryDTO] = (
        (JsPath \ "id").read[Long] and
        (JsPath \ "name").read[String] and
        (JsPath \ "description").read[String]
    )(CategoryDTO.apply _)
}