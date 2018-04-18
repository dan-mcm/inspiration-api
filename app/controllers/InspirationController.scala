package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.collection.mutable.ArrayBuffer

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class InspirationController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(generateQuote(y, scala.util.Random.nextInt(10)))
  }

  // json method of generating quotes
  // (y(scala.util.Random.nextInt(10))\"quote").get

  var y: JsValue = Json.arr(
      Json.obj("quote" -> "Make your life a masterpiece, imagine no limitations on what you can be, have or do.", "author" -> "Brian Tracy"),
      Json.obj("quote" -> "We may encounter many defeats but we must not be defeated.", "author" -> "Maya Angelou"),
      Json.obj("quote" -> "I am not a product of my circumstances. I am a product of my decisions.", "author" -> "Stephen Covey"),
      Json.obj("quote" -> "We must let go of the life we have planned, so as to accept the one that is waiting for us.", "author" -> "Joseph Campbell"),
      Json.obj("quote" -> "Believe you can and you're halfway there.", "author" -> "Theodore Roosevelt"),
      Json.obj("quote" -> "We know what we are, but know not what we may be.", "author" -> "William Shakespeare"),
      Json.obj("quote" -> "We can't help everyone, but everyone can help someone.", "author" -> "Ronald Reagan"),
      Json.obj("quote" -> "When you have a dream, you've got to grab it an never let go.", "author" -> "Carol Burnett"),
      Json.obj("quote" -> "Your present circumstances don't determine where you can go; they merely determine where you start.", "author" -> "Nido Quebein"),
      Json.obj("quote" -> "Thinking: the talking of the soul with itself.", "author" -> "Plato")
    )

  // Function that returns a random string include quote & author
  def generateQuote( quotes:JsValue, random:Int) : String = {
    var quote:JsValue = (quotes(random)\"quote").get
    var author:JsValue = (quotes(random)\"author").get
    return (author.as[String] + ": " + quote.as[String])
  }

  // array method of generating quotes
  // quotes(scala.util.Random.nextInt(10))
  //  var quotes = ArrayBuffer[String]()
  //  quotes += "Make your life a masterpiece, imagine no limitations on what you can be, have or do. - Brian Tracy"
  //  quotes += "We may encounter many defeats but we must not be defeated. - Maya Angelou"
  //  quotes += "I am not a product of my circumstances. I am a product of my decisions. - Stephen Covey"
  //  quotes += "We must let go of the life we have planned, so as to accept the one that is waiting for us. - Joseph Campbell"
  //  quotes += "Believe you can and you're halfway there. - Theodore Roosevelt"
  //  quotes += "We know what we are, but know not what we may be. - William Shakespeare"
  //  quotes += "We can't help everyone, but everyone can help someone. - Ronald Reagan"
  //  quotes += "When you have a dream, you've got to grab it an never let go. - Carol Burnett"
  //  quotes += "Your present circumstances don't determine where you can go; they merely determine where you start. - Nido Quebein"
  //  quotes += "Thinking: the talking of the soul with itself. - Plato"

}

