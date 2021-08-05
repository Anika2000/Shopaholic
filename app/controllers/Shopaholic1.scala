package controllers

import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

//used to do dependency injection
@Singleton
class Shopaholic1 @Inject()(val controllerComponents: ControllerComponents) extends BaseController{
  def shoppingCart = Action {
    val items = List("Barbie Doll", "Balloons", "Crayons")
    Ok(views.html.shoppingCart(items))
  }
}
