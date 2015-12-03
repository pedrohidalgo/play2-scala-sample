package converter

import models.Category
import models.CategoryDTO

object CategoryConverter extends ParentConverter[Category, CategoryDTO]{
    
    override def dtoToObj(dto: CategoryDTO) = {
        val category = new Category
        category.id = dto.id
        category.name = dto.name
        category.description = dto.description
        
        category
    }
    
    override def objToDTO(category: Category) = {
        new CategoryDTO(category.id, category.name, category.description)
    }

}