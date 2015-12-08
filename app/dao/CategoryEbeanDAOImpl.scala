package dao

import models.Category
import scala.collection.JavaConversions._

class CategoryEbeanDAOImpl extends CategoryDAO {

    def findAll() = {
        Category.find.all
    }
    
    def save(cat: Category) = {
        val newCategory = new Category
        newCategory.name = cat.name
        newCategory.description = cat.description
        
        newCategory.save
        
        newCategory
    }

}