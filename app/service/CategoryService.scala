package service

import converter.CategoryConverter
import dao.CategoryEbeanDAOImpl

object CategoryService {

    //TODO use DI
    val categoryDAO = new CategoryEbeanDAOImpl
    
    def findAll = {
        categoryDAO.findAll.map(ca => CategoryConverter.objToDTO(ca))
    }

}
