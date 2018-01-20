/**
  * Created by vagrant on 2018/01/20.
  */
import sbt._
import scala.Some

object Version {
  val thisApp = "1.0.0-SNAPSHOT"
  val scala = "2.10.2"
  val dropWizard = "0.6.2"
  val json4s = "3.2.4"
  val salat = "1.9.2"
}



object Dependencies {

  import Version._

  object Compile {
    val nscalaTime = "com.github.nscala-time" %% "nscala-time" % "0.4.0"
    val json4sJackson = "org.json4s" %% "json4s-jackson" % json4s
    val dropWizardClient = "com.yammer.dropwizard" % "dropwizard-client" % dropWizard
    val dropWizardScala = "com.massrelevance" %% "dropwizard-scala" % "0.6.2-1"

    val casbah = "org.mongodb" %% "casbah-core" % "2.6.1"
    val mongoJavaDriver = "org.mongodb" % "mongo-java-driver" % "2.11.1"
    val salatCore = "com.novus" %% "salat-core" % salat
    val salatUtil = "com.novus" %% "salat-util" % salat

    val swagger = "com.wordnik" % "swagger-jaxrs_2.10.0" % "1.2.5"
    val dropwizardSwagger = "io.tesla.dropwizard" % "dropwizard-swagger" % "0.1.1"

  sealed abstract class Test(scope: String) {
    val scalaTest = "org.scalatest" %% "scalatest" % "2.0.M5b" % scope
    val junit = "junit" % "junit" % "4.11" % scope
    val mockito = "org.mockito" % "mockito-all" % "1.9.5" % scope
    val dropWizardTest = "com.yammer.dropwizard" % "dropwizard-testing" % dropWizard % scope
    val httpClient = "org.apache.httpcomponents" % "httpclient" % "4.2.2" % scope
  }

  object Test extends Test("test")

  object IntegrationTest extends Test("it")

  val commonDependencies = Seq(
    Compile.nscalaTime,
    Compile.json4sJackson,
    Compile.dropWizardClient,
    Compile.dropWizardScala,
    Compile.casbah,
    Compile.mongoJavaDriver,
    Compile.salatCore,
    Compile.salatUtil,
    Compile.swagger,
    Compile.dropwizardSwagger,

    Test.scalaTest,
    Test.junit,
    Test.mockito,
    Test.dropWizardTest,
    Test.httpClient
  )

}
