package controllers

import models.ShopaholicUser
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class Shopaholic @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def shoppingCart() = Action { implicit request =>
    val username = request.session.get("username")
    username.map { username =>
      val items = ShopaholicUser.getShoppingCartItems(username)
      Ok(views.html.shoppingCart(items))
    }.getOrElse(Redirect(routes.HomeController.index()))
  }

  def addListing = Action { implicit request =>
    val username = request.session.get("username")
    username.map { username =>
      val values = request.body.asFormUrlEncoded
      values.map { args =>
        val item = args("new-item").head
        ShopaholicUser.addListing(item)
        Redirect(routes.HomeController.home)
      }.getOrElse(Redirect(routes.HomeController.home))
    }.getOrElse(Redirect(routes.HomeController.login))
  }

  def logout = Action {
    Redirect(routes.HomeController.index()).withNewSession
  }

  def deleteItem = Action { implicit request =>
    val username = request.session.get("username")
    username.map { username =>
      val values = request.body.asFormUrlEncoded
      values.map { args =>
        val index = args("index").head.toInt
        ShopaholicUser.removeItem(username, index)
        Redirect(routes.Shopaholic.shoppingCart())
      }.getOrElse(Redirect(routes.Shopaholic.shoppingCart()))
    }.getOrElse(Redirect(routes.HomeController.login))
  }

  def addItem = Action { implicit request =>
    val username = request.session.get("username")
    username.map { username =>
      val values = request.body.asFormUrlEncoded
      values.map { args =>
        //have doubts about line 53
        val item = args("add-to-cart").head
        ShopaholicUser.addItem(username, item)
        Redirect(routes.Shopaholic.shoppingCart())
      }.getOrElse(Redirect(routes.Shopaholic.shoppingCart()))
    }.getOrElse(Redirect(routes.HomeController.login))
  }
}
