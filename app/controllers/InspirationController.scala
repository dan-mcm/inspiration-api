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
    Ok(quotes(scala.util.Random.nextInt(10)))
  }

  var quotes = ArrayBuffer[String]()
  quotes += "Make your life a masterpiece, imagine no limitations on what you can be, have or do. - Brian Tracy"
  quotes += "We may encounter many defeats but we must not be defeated. - Maya Angelou"
  quotes += "I am not a product of my circumstances. I am a product of my decisions. - Stephen Covey"
  quotes += "We must let go of the life we have planned, so as to accept the one that is waiting for us. - Joseph Campbell"
  quotes += "Believe you can and you're halfway there. - Theodore Roosevelt"
  quotes += "We know what we are, but know not what we may be. - William Shakespeare"
  quotes += "We can't help everyone, but everyone can help someone. - Ronald Reagan"
  quotes += "When you have a dream, you've got to grab it an never let go. - Carol Burnett"
  quotes += "Your present circumstances don't determine where you can go; they merely determine where you start. - Nido Quebein"
  quotes += "Thinking: the talking of the soul with itself. - Plato"
//  var random = scala.util.Random
//  var selected = random.nextInt(10)

}
