package in.reqres.usersadmin.testing.stepdefinitions;

import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class DeleteUserStepDefinition {

    @When("^se envia el id \"([^\"]*)\" del usuario a eliminar al servicio \"([^\"]*)\"$")
    public void seEnviaElIdDelUsuarioAEliminarAlServicio(String id, String url)  {
        String path = "/" + id;
        SerenityRest.given().baseUri(url).delete(path);
    }
}
