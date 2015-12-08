package service

import converter.CategoryConverter
import dao.CategoryEbeanDAOImpl
import models.CategoryDTO

object CategoryService {

    //TODO use DI
    val categoryDAO = new CategoryEbeanDAOImpl
    
    def findAll = {
        categoryDAO.findAll.map(ca => CategoryConverter.objToDTO(ca))
    }
    
    def save(dto: CategoryDTO) = {
        val objCategory = CategoryConverter.dtoToObj(dto)
        val objCategoryInDB = categoryDAO.save(objCategory)
        
        CategoryConverter.objToDTO(objCategoryInDB)
    }

}
