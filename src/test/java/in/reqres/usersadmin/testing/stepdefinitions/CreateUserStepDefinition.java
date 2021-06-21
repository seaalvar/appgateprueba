package in.reqres.usersadmin.testing.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import java.util.Map;

public class CreateUserStepDefinition {

    @When("^se envia la siguiente informacion del usuario al servicio \"([^\"]*)\"$")
    public void seEnviaLaSiguienteInformacionDelUsuarioAlServicio(String url, Map<String,String> cuerpo) {
        SerenityRest.given().baseUri(url).body(cuerpo).post();
    }

    @Then("^se valida que el codigo de status sea (\\d+)$")
    public void seValidaQueElCodigoDeStatusSea(int status) {
        SerenityRest.lastResponse().then().statusCode(status);
    }


}
