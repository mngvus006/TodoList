
package Representation

/**
  * Created by Vusi Mngomezulu.
  */
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.adapters.MSSQLServer
import org.squeryl.{Schema, Session, SessionFactory}
case class Todo(id:Int, task: String,active: Int, completed: Int) {}
case class TodoWithoutId(task: String,active: Int, completed: Int) {}

object TodoListSchema extends Schema {
  // Setup the TodoListSchema class to be mapped to the "TodoList" table in SQL Server
  val todoList = table[Todo]("Todo")
  val todoListWithoutId = table[TodoWithoutId]("Todo")
}

object SquerylTodoListRepository {
  val databaseConnectionUrl = "jdbc:jtds:sqlserver://localhost;DatabaseName=TodoListDB"
  val databaseUsername = "SA"
  val databasePassword = "Skeleton10111"


  // Set the jtds driver
  Class.forName("net.sourceforge.jtds.jdbc.Driver")
  // Connect to the database
  SessionFactory.concreteFactory = Some(()=>
    Session.create(
      java.sql.DriverManager.getConnection(databaseConnectionUrl, databaseUsername, databasePassword),
      new MSSQLServer))

 def addTask(task : String) =
   transaction {
     TodoListSchema.todoListWithoutId.insert(new TodoWithoutId(task, 0, 0))
   }

  def deleteTask(id: Int) =
    transaction {
      TodoListSchema.todoList.deleteWhere(x => x.id === id)
    }
  // status = 2 is checked and status = 1 is uncheck
  def setCompleted(status: Int, id: Int) =
    transaction {
      update(TodoListSchema.todoList)(listItem => where(listItem.id === id) set (listItem.completed := status))
    }

  def setActivated(status: Int, id: Int) =
    transaction {
      update(TodoListSchema.todoList)(listItem => where(listItem.id === id) set (listItem.active := status))
    }

  def getActivated(status: Int): List[Todo] =
    transaction {
      from(TodoListSchema.todoList)(listItem => where(listItem.active === status) select (listItem)).toList
    }

  def getCompleted(status: Int): List[Todo] =
    transaction {
      from(TodoListSchema.todoList)(listItem => where(listItem.completed === status) select (listItem)).toList
    }

  def getTodoList(): List[Todo] =
    transaction {
      from(TodoListSchema.todoList)( x => select (x) ).toList
   }
  

}
