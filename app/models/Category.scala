package models

import javax.persistence.Entity
import javax.persistence.Id
import com.avaje.ebean.Model
import javax.persistence.Column

case class CategoryDTO(id:Long , name: String, description: String)

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
    val find = new Model.Finder[Long, Category](classOf[Category])
    import play.api.libs.json._

    val categoryWrites = new Writes[CategoryDTO] {
        def writes(category: CategoryDTO) = Json.obj(
            "id" -> category.id,
            "name" -> category.name,
            "description" -> category.description
        )
    }
}