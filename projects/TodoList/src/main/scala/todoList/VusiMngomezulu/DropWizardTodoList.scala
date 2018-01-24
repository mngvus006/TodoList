package todoList.VusiMngomezulu



import com.massrelevance.dropwizard.bundles.ScalaBundle
import io.dropwizard.Application
import io.dropwizard.setup.{Bootstrap, Environment}
import resources.TodoListResource
/**
  * Created by vagrant on 2018/01/19.
  */
class DropWizardTodoList  extends Application[DropWizardConfig] {

 override def initialize(bootstrap: Bootstrap[DropWizardConfig]): Unit = {
   // Various set ups
    bootstrap.addBundle(new ScalaBundle)
  }

  override def run(config: DropWizardConfig, env: Environment): Unit ={
    //Register RESTful things
    env.jersey().register(new TodoListResource)
  }
}

object DropWizardTodoList {
  final def main(args: Array[String]) = {
    (new DropWizardTodoList).run(args)
  }
}
