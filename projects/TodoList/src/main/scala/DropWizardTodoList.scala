import resources.TodoListResource

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
  * Created by vagrant on 2018/01/19.
  */
class DropWizardTodoList  extends Application[DropWizardConfig] with Logging {

  override def getName = "DropWizzard example"

  override def initialize(bootstrap: Boostrap[DwExampleConfig]): Unit = {
    //Various set ups
    boostrap.addBundle(new ScalaBundle)
  }

  override def run(config: DropWizardConfig, env:Enviroment): Unit ={
    //Register RESTful things
    env.jersey().register(new TodoListResource)

  }
}
