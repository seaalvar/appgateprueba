package in.reqres.usersadmin.testing.stepdefinitions;

import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class UpdateUserStepDefinition {

    @When("^se envia la siguiente actualizacion del usuario con id \"([^\"]*)\" al servicio \"([^\"]*)\"$")
    public void seEnviaLaSiguienteActualizacionDelUsuarioConIdAlServicio(String id, String url, Map<String,String> cuerpo)  {
        String path = "/" + id;
        SerenityRest.given().baseUri(url).body(cuerpo).put(path);
    }
}
