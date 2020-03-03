package controllers

import javax.inject._
import play.api._
import play.api.mvc._

// Here we experiment with different types of routing in play framework
// Play supports all the standard HTTP methods such as GET, PATCH, POST, PUT, DELETE, HEAD

@Singleton
class RoutingController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def echo(content: String) = Action { implicit request: Request[AnyContent] =>
    Ok(s"Echoing the input paramter: ${content}")
  }

  //  pageNo or any other name for the variable should work

  def page(pageNo: Int) =  Action { implicit request: Request[AnyContent] =>
    Ok(s"You have requested page no ${pageNo}")
  }

  def pageByName(name: String) =  Action { implicit request: Request[AnyContent] =>
    Ok(s"You have requested page nby name ${name}")
  }

  // Note: The parameter defined in routes does not have to match with the parameter defined on the controller action
  // here I have defined pageNo as parameter in the routes file but I am using num in the action.

  def getPage(num: Int) =  Action { implicit request: Request[AnyContent] =>
    Ok(s"You have requested page no ${num}")
  }

  def skipCsrfFilter =  Action { implicit request: Request[AnyContent] =>
    Ok("I am skipping CSRF verification filter for this action")
  }

  //  filpath or any other name for the variable should work
  def multiPathMatch(filepath: String) = Action { implicit request: Request[AnyContent] =>
    Ok(filepath)
  }

  def parameter(name: String, age: Int)  = Action { implicit request: Request[AnyContent] =>
    Ok(s"You have specified name as ${name} and age as ${age}")
  }

  def optionalParameter(version: Option[String]) =  Action { implicit request: Request[AnyContent] =>
    Ok(s"You have specified version ${version}")
  }

  def listParameter(items:  List[String])  = Action { implicit request: Request[AnyContent] =>
    Ok(s"You have provided a list of the following: ${items}")
  }

}