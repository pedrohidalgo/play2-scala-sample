package misc

import models.Article
import models.Category
import play.api.Logger
import slick.driver.PostgresDriver.api._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.reflect.io.File

class SchemaGenerator extends Runnable {

  def run = {
    println("---------------------GENERATING SCHEMA.....")
    val categories = TableQuery[Category]
    val articles = TableQuery[Article]

    val file = File("/home/pedro/NetBeansProjects/play-scala-angular-sample/my-blog-server/conf/evolutions/default/1.sql")

    val sb = new StringBuilder("# --- !Ups  \n\n")
    categories.schema.create.statements.foreach(st => sb.append(st.toString + ";\n"))
    sb.append("\n\n")
    articles.schema.create.statements.foreach(st => sb.append(st.toString + ";\n"))

    sb.append("\n\n")
    sb.append("# --- !Downs")
    sb.append("\n\n")

    categories.schema.drop.statements.foreach(st => sb.append(st.toString + ";\n"))
    sb.append("\n\n")
    articles.schema.drop.statements.foreach(st => sb.append(st.toString + ";\n"))

//    Logger.info("value: [" + sb + "] sb")
    file.writeAll(sb.toString)
    Logger.info("----------------------FINISHED GENERATING SCHEMA--------------------------")
  }

}
