import resources.TodoListResource

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment



/**
  * Created by vagrant on 2018/01/19.
  */
class DropWizardTodoList  extends Application[DropWizardConfig]  {
  /*@throws[Exception]
  def main(args: Array[String]): Unit = {
    new DropWizardTodoList().run(args)
  }*/
  override def getName = "DropWizzard example"

  override def initialize(bootstrap: Bootstrap[DropWizardConfig]): Unit = {
    //Various set ups
   // bootstrap.addBundle(new ScalaBundle)
   // bootstrap.addBundle(new ScalaBundle)
  }

  override def run(config: DropWizardConfig, env:Environment ): Unit ={
    //Register RESTful things
    env.jersey().register(new TodoListResource)

  }
}
