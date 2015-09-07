package models

import slick.driver.PostgresDriver.api._

case class ArticleDTO(var title: String, var content: String, var category: Category)

class Article(tag: Tag) extends Table[(Long, String, String, Long)](tag, "ARTICLE") {
  def id = column[Long]("ID", O.PrimaryKey) // This is the primary key column
  def title = column[String]("title")
  def content = column[String]("CONTENT")
  def categoryId = column[Long]("CATEGORY_ID") 

  def * = (id, title, content, categoryId)
  //    def * = (id, name, content, category)
  // A reified foreign key relation that can be navigated to create a join
  def category = foreignKey("CAT_FK", categoryId, TableQuery[Category])(_.id)
}
