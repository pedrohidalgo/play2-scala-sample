package dao

import models.Category
import scala.collection.JavaConversions._

class CategoryEbeanDAOImpl extends CategoryDAO {

    def findAll() = {
        Category.find.all
    }

}