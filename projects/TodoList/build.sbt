import Dependencies.ProjectDependencies
import AssemblyKeys._
name := "TodoList"

version := "1.0"

scalaVersion := "2.12.4"



mainClass in(Compile, run) := Some("todoList.VusiMngomezulu.DropWizardTodoList")

libraryDependencies ++= ProjectDependencies

