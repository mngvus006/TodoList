
package todoList.VusiMngomezulu.resources

import todoList.VusiMngomezulu.Representation.{SquerylTodoListRepository, Todo}
import javax.ws.rs.{DELETE, GET, POST, PUT, Path, PathParam, Produces}

import io.swagger.annotations.{Api, ApiOperation, ApiParam}
import javax.ws.rs.core.MediaType

import com.codahale.metrics.annotation.{ExceptionMetered, Metered}

@Path("/TodoList-Resource")
@Produces(Array(MediaType.APPLICATION_JSON))
@Api(value = "ToDoLIst REST API")
class TodoListResource {
   @POST
   @Path("/addTask/{task}")
   @ApiOperation(value = "Add a new task")
  def addTask(@PathParam("task") task: String ) = {
     SquerylTodoListRepository.addTask(task)
  }

  @DELETE @Path("/deleteTask/{id}")
  @ApiOperation(value = "Removes a done task")
  def deleteTask(@PathParam("id") id: Int) = {
    SquerylTodoListRepository.deleteTask(id)
  }

  @PUT
  @Path("/setCompleted/{status}/{id}")
  @ApiOperation(value = "Mark task as completed")
  def setCompleted(@PathParam("status") status: Int, @PathParam("id") id: Int) = {
    SquerylTodoListRepository.setCompleted(status,id)
  }

  @PUT
  @Path("/setActivated/{status}/{id}")
  @ApiOperation(value = "Mark task as activated")
  def setActivated(@PathParam("status") status: Int, @PathParam("id") id: Int) ={
    SquerylTodoListRepository.setActivated(status,id)
  }

  @GET
  @Path("/getActivatedTasks/{status}")
 // @Produces({"application/json", "application/xml"})
  @ApiOperation(value = "Retrieve all activated tasks", produces = MediaType.APPLICATION_JSON)
  def getActivated(@PathParam("status") status: Int): List[Todo]={
    SquerylTodoListRepository.getActivated(status)
  }

  @GET
  @Path("/getCompletedTasks/{status}")
  @ApiOperation(value = "Retrieve all completed tasks", produces = MediaType.APPLICATION_JSON)
  def getCompleted(@PathParam("status") status: Int): List[Todo] = {
    SquerylTodoListRepository.getCompleted(status)
  }

  @GET
  @Path("/getTodoList/")
  @ApiOperation(value = "Retrieve all tasks noted", produces = MediaType.APPLICATION_JSON)
  def getTodoList(): List[Todo] = {
    SquerylTodoListRepository.getTodoList()
  }

  @GET
  @Path("/hello/")
  @ExceptionMetered(name = "hello-errors")
  @ApiOperation(value = "Say Hello World!", notes = "Greets the World.", response = classOf[String], produces = MediaType.TEXT_PLAIN)
  def helloWorld: String = {
    "Hello World"
  }

}
