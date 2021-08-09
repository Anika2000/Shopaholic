package controllers

import models.ShopaholicUser

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  /**
   * This is the for the user login
   */
  def login = Action { request =>
    //decoding the request because the body contains the info and it is encoded
    val value = request.body.asFormUrlEncoded
    value.map { args =>
      val username = args("username").head
      val password = args("password").head
      if(ShopaholicUser.validateUser(username, password)){
        Redirect(routes.Shopaholic.shoppingCart()).withSession("username" -> username)
      } else {
        Redirect(routes.HomeController.index())
      }
    }.getOrElse(Redirect(routes.HomeController.index()))
  }

  /**
   * This to create a user
   */
  def createUser = Action { request =>
    val userInfo = request.body.asFormUrlEncoded
    userInfo.map { args =>
      val username = args("username").head
      val password = args("password").head
      if(ShopaholicUser.createUser(username, password)){
        Redirect(routes.Shopaholic.shoppingCart()).withSession("username" -> username)
      } else {
        Redirect(routes.HomeController.index())
      }
    }.getOrElse(Redirect(routes.HomeController.index()))
  }

  def home() = Action { implicit request =>
    val something = ShopaholicUser.allListings()
    Ok(views.html.home(something))
  }

  //check-out stuff:
  def checkout = Action { implicit request =>
    val username = request.session.get("username")
    username.map { username =>
      val items = ShopaholicUser.getShoppingCartItems(username)
      Ok(views.html.out(items))
    }.getOrElse(Redirect(routes.HomeController.index()))
  }
}
