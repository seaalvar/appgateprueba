package in.reqres.usersadmin.testing.testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/UsersList.feature",
        glue = "in.reqres.usersadmin.testing.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class UsersListRunner {
}
