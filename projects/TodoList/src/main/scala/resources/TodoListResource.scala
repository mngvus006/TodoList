package resources

import Representation.{SquerylTodoListRepository, Todo}
import javax.ws.rs.{DELETE, PUT, Path,PathParam,GET, Consumes}
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong


@Path("/TodoList-Resource")
@Produces(MediaType.APPLICATION_JSON)

public class TodoListResource {

  val n = "API";

    @PUT
   @Path("/addTask/{task}")
  def addTask(@PathParam("task") task: String ) = {
     SquerylTodoListRepository.addTask(task)
  }

  @DELETE @Path("/deleteTask/{id}")
  def deleteTask(@PathParam("id") id: Int) = {
    SquerylTodoListRepository.deleteTask(id)
  }

  @PUT
  @Path("/setCompleted/{status}/{id}")
  def setCompleted(@PathParam("status") status: Int, @PathParam("id") id: Int) = {
    SquerylTodoListRepository.setCompleted(status,id)
  }

  @PUT
  @Path("/setActivated/{status}/{id}")
  def setActivated(@PathParam("status") status: Int, @PathParam("id") id: Int) ={
    SquerylTodoListRepository.setActivated(status,id)
  }

  @GET
  @Path("/getActivatedTasks/{status}")
 // @Produces({"application/json", "application/xml"})
  def getActivated(@PathParam("status") status: Int): List[Todo]={
    SquerylTodoListRepository.getActivated(status)
  }

  @GET
  @Path("/getCompletedTasks/{status}")
  def getCompleted(@PathParam("status") status: Int): List[Todo] = {
    SquerylTodoListRepository.getCompleted(status)
  }

  @GET
  @Path("/getCompletedTasks/")
  def getTodoList(): List[Todo] = {
    SquerylTodoListRepository.getTodoList()
  }




}
