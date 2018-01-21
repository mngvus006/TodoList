import com.sun.istack.internal.NotNull
import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty


/**
  * Created by vagrant on 2018/01/19.
  */
class DropWizardConfig extends Configuration {

  @NotNull
  @JsonProperty
  val hostname = "localhost:8080"


}
