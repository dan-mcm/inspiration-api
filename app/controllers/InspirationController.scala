package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.collection.mutable.ArrayBuffer

import scala.slick.driver.PostgresDriver.simple._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class InspirationController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(generateQuote(scala.util.Random.nextInt(10)))
  }

  // Function that returns a random string include quote & author
  def generateQuote(random:Int) : String = {

    var output = ""
    val connectionUrl = "jdbc:postgresql://localhost:5432/inspiration_db?user=user"

    // connecting to postgres db for accessing data
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val quotes = TableQuery[Quotes]

        // SELECT * FROM quotations WHERE id=randomInt
        quotes.filter(_.index === random+1).list foreach { row =>
          output = row._2 + ": " + row._3
        }
      }
    return output
  }
}


// Matches schema of our docker-compose psql DB quotations table
class Quotes(tag: Tag) extends Table[(Int, String, String)](tag, "quotations") {
  def index = column[Int]("index")
  def author = column[String]("author")
  def quote = column[String]("quote")
  def * = (index, author, quote)
}