package controllers

import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

//used to do dependency injection
@Singleton
class Shopaholic1 @Inject()(val controllerComponents: ControllerComponents) extends BaseController{
  def login = Action {
    Ok(views.html.login())
  }
  def validateLogin() = Action { request =>
      val input = request.body.asFormUrlEncoded
    input.map{ args =>
      val username = args("username").head
      val password = args("password").head
      Redirect(routes.Shopaholic1.shoppingCart())
    }.getOrElse(Redirect(routes.Shopaholic1.login()))
  }

  def shoppingCart = Action {
    val items = List("Barbie Doll", "Balloons", "Crayons")
    Ok(views.html.shoppingCart(items))
  }
}
