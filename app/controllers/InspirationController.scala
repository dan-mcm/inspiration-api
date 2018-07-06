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

  def save() = Action { request =>
    val body: AnyContent = request.body
    val json: Option[JsValue] = body.asJson
    val author = json.get("author").toString.stripPrefix("\"").stripSuffix("\"").trim
    val quote = json.get("quote").toString.stripPrefix("\"").stripSuffix("\"").trim
    saveQuote(author, quote)
    Ok("Successfully updated quotations DB")

  }

  val connectionUrl = "jdbc:postgresql://localhost:5432/inspiration_db?user=user"

  def generateQuote(random:Int) : String = {
    var output = ""

    // connecting to postgres db for accessing data
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val quotes = TableQuery[Quotes]

        // SELECT * FROM quotations WHERE id=randomInt
        quotes.filter(_.index === random+1).list foreach { row =>
          output = row._2 + ": " + row._3
        }
      }
    output
  }

  def saveQuote(author:String, quote:String): Unit ={
    var index = 0
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val quotes = TableQuery[Quotes]
        // getting id of last element in table
        quotes.sortBy(_.index.desc).take(1).list foreach { row =>
          index = row._1 + 1
        }
        quotes += (index, author, quote)
    }
  }
}

// Matches schema of the docker-compose psql DB quotations table
class Quotes(tag: Tag) extends Table[(Int, String, String)](tag, "quotations") {
  def index = column[Int]("index")
  def author = column[String]("author")
  def quote = column[String]("quote")
  def * = (index, author, quote)
}