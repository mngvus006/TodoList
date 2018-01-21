name := "TodoList"

version := "1.0"

scalaVersion := "2.12.4"



libraryDependencies  ++=  Seq(
  "org.squeryl" %% "squeryl" % "0.9.9",
  "net.sourceforge.jtds" % "jtds" % "1.3.1",
  "io.dropwizard" % "dropwizard-core" % "1.0.2",
  "com.sun.jersey" % "jersey-client" % "1.19",
  "com.yammer.dropwizard" % "dropwizard-core" % "0.6.2"
)