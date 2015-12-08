package dao

import models.Category
import scala.collection.mutable.Buffer

trait CategoryDAO {

    def findAll(): Buffer[Category]
    def save(cat: Category): Category

}