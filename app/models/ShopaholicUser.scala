package models

import javax.print.attribute.standard.RequestingUserName
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
//This will be lost when server goes down
object ShopaholicUser {
    //only username and password stored in users map. First it takes a username key and
    //gives you back a password
    private val users = mutable.Map[String, String]("Anika" -> "ok")
    private val shoppingCartItems = mutable.Map[String, List[String]]("Anika" -> List("Barbie", "Crayons", "Balloons"))
    private val listings = new ListBuffer[String]()
    listings += "Barbie"
    listings += "Crayons"
    listings += "Balloons"

    def allListings() : ListBuffer[String] = {
        return listings
    }

    def addListing(item: String) : Unit = {
        listings += item
    }

    def validateUser(username:String, password:String): Boolean = {
        users.get(username).map(_ == password).getOrElse(false)
    }

    def createUser(username: String, password: String): Boolean = {
        if(users.contains(username)) false  //gives back me a key to see if username already exists as a key
        else {
            users(username) = password      //set username with the given password
            true
        }
    }

    def getShoppingCartItems(username:String) : Seq[String] = {
        shoppingCartItems.get(username).getOrElse(Nil)
    }

    def addItem(username: String, item:String) : Unit ={
        shoppingCartItems(username) = item :: shoppingCartItems.get(username).getOrElse(Nil)
    }

    def removeItem(username: String, index: Int): Boolean = {
        if(index < 0 || shoppingCartItems.get(username).isEmpty || index >= shoppingCartItems(username).length) false
        else {
            shoppingCartItems(username) = shoppingCartItems(username).patch(index, Nil, 1)
            true
        }
    }

}
