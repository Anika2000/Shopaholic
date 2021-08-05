
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object shoppingCart extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(items: Seq[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.22*/("""

"""),_display_(/*3.2*/main("Shopping Cart")/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""
    """),format.raw/*4.5*/("""<h2>Shopping Cart</h2>
    <ul>
        """),_display_(/*6.10*/for(item <- items) yield /*6.28*/{_display_(Seq[Any](format.raw/*6.29*/("""
            """),format.raw/*7.13*/("""<li>"""),_display_(/*7.18*/item),format.raw/*7.22*/("""</li>
        """)))}),format.raw/*8.10*/("""
    """),format.raw/*9.5*/("""</ul>
""")))}))
      }
    }
  }

  def render(items:Seq[String]): play.twirl.api.HtmlFormat.Appendable = apply(items)

  def f:((Seq[String]) => play.twirl.api.HtmlFormat.Appendable) = (items) => apply(items)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/shoppingCart.scala.html
                  HASH: f48621c6df04c936fc1c9780d8b53591e9409492
                  MATRIX: 741->1|856->21|886->26|915->47|954->49|986->55|1055->98|1088->116|1126->117|1167->131|1198->136|1222->140|1268->156|1300->162
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|31->6|31->6|31->6|32->7|32->7|32->7|33->8|34->9
                  -- GENERATED --
              */
          