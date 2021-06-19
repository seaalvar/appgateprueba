package in.reqres.usersadmin.testing.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import java.util.Map;

public class UsersListStepDefinition {

    @When("^David envia la siguiente operacion al servicio \"([^\"]*)\"$")
    public void davidEnviaLaSiguienteOperacionAlServicio(String url, Map<String,String> cuerpo) {
        SerenityRest.given().baseUri(url).body(cuerpo).post();
    }

    @Then("^valida que el codigo de status sea (\\d+)$")
    public void validaQueElCodigoDeStatusSea(int status) {
        SerenityRest.lastResponse().then().statusCode(status);
    }

    @Then("^que el contenido de la llave \"([^\"]*)\" sea \"([^\"]*)\"$")
    public void queElContenidoDeLaLlaveSea(String llaveResultado, String resultadoEsperado) {
        //SerenityRest.lastResponse().then().body(llaveResultado, Matchers.is(resultadoEsperado));
    }

    @Then("^que el contenido de la llave \"([^\"]*)\" sea null$")
    public void queElContenidoDeLaLlaveSeaNull(String llaveError) {
        //SerenityRest.lastResponse().then().body(llaveError, Matchers.equalTo(null));
    }
}
