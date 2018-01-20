package resources

import jdk.nashorn.internal.objects.annotations.Getter

/**
  * Created by vagrant on 2018/01/19.
  */
class TodoListResource {

  @Get
  def helloWorld: String = {
    "Hellow"
  }
}
