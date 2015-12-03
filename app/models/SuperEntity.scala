package models

import com.avaje.ebean.Model
import java.util.Date
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
abstract class SuperEntity extends Model {

  @Id
  var id: Long = _

  @Column(nullable = false)
  var insertionDate: Date = _

  @Version
  @Column(columnDefinition = "integer default 1")
  var version: Int = _

  override def save() {
    insertionDate = new Date()
    super.save()
  }
}