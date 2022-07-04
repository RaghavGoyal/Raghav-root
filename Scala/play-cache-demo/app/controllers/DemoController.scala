package controllers

import play.api.mvc.{BaseController, ControllerComponents}
import service.DemoService

import javax.inject.Inject

class DemoController @Inject()(val controllerComponents: ControllerComponents,
                               service: DemoService
                              ) extends BaseController{

  def start(key: String) = Action {
    val response = service.fetchData(key)
    Ok(response)
  }

}
