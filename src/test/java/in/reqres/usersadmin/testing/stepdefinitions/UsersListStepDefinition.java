package in.reqres.usersadmin.testing.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;

import java.util.Map;

public class UsersListStepDefinition {

    @When("^se envia la peticion de listar usuarios al servicio \"([^\"]*)\"$")
    public void seEnviaLaPeticionDeListarUsuariosAlServicio(String url)  {
        SerenityRest.given().baseUri(url).get();
    }

    @Then("^se valida numero de registros \"([^\"]*)\" sea \"([^\"]*)\"$")
    public void seValidaNumeroDeRegistrosPorPaginaSea(String llaveResultado, int nroRegistros)  {
        System.out.println(SerenityRest.lastResponse().asString());
        SerenityRest.lastResponse().then().body(llaveResultado, Matchers.is(nroRegistros));
    }

    @When("^se envia el numero de pagina \"([^\"]*)\" a consultar al servicio \"([^\"]*)\"$")
    public void seEnviaElNumeroDePaginaAConsultarAlServicio(String pagina, String url) {
        SerenityRest.given().get(url+pagina);
    }

    @Then("^se valida el contenido de la \"([^\"]*)\" sea \"([^\"]*)\"$")
    public void seValidaElContenidoDeLaSea(String llave, int valor) {
        SerenityRest.lastResponse().then().body(llave, Matchers.is(valor));
    }


    @Then("^se valida que la informacion del registro \"([^\"]*)\" sea \"([^\"]*)\" \"([^\"]*)\"$")
    public void seValidaQueLaInformacionDelRegistroSea(int registro, String llaveResultado, String resultadoEsperado)  {
        String path = "data[" + (registro-1) + "]." + llaveResultado;
        SerenityRest.lastResponse().then().body(path, Matchers.is(resultadoEsperado));
    }
}
