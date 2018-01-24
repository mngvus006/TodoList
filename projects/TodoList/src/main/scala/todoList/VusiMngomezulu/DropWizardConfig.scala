package todoList.VusiMngomezulu


import io.dropwizard.Configuration
import javax.validation.constraints.NotNull
import javax.validation.Valid
import io.dropwizard.server.{SimpleServerFactory, ServerFactory}
import com.fasterxml.jackson.annotation.JsonProperty


/**
  * Created by vagrant on 2018/01/19.
  */
class DropWizardConfig extends Configuration {
  @Valid
  @NotNull
  private val server: ServerFactory = new SimpleServerFactory

  @NotNull
  @JsonProperty
  val hostname = "localhost:8080"


}
