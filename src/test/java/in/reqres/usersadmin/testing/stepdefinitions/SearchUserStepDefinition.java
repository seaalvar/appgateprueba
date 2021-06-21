package in.reqres.usersadmin.testing.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;


public class SearchUserStepDefinition {

    @When("^se envia el id \"([^\"]*)\" del usuario a buscar al servicio \"([^\"]*)\"$")
    public void seEnviaElIdDelUsuarioABuscarAlServicio(String id, String url) {
        String path = "/" + id;
        SerenityRest.given().baseUri(url).get(path);
    }

    @Then("^se valida que el contenido de la \"([^\"]*)\" sea \"([^\"]*)\"$")
    public void seValidaQueElContenidoDeLaLlaveSea(String llaveResultado, String resultadoEsperado) {
        String path = "data." + llaveResultado;
        SerenityRest.lastResponse().then().body(path, Matchers.is(resultadoEsperado));
    }
}
