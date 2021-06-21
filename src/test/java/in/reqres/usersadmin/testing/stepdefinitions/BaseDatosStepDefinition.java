package in.reqres.usersadmin.testing.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import in.reqres.usersadmin.testing.utils.ConexionBD;

import java.sql.SQLException;


public class BaseDatosStepDefinition {

    @When("^se crea el empleado en la base de datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void seCreaElEmpleadoEnLaBaseDeDatos(int idEmpleado, String nombre, int meses, int salario) throws SQLException {
        ConexionBD.initConnection();
        ConexionBD.insertEmployee(idEmpleado, nombre, meses, salario);
    }

    @When("^se listan empleados con al menos \"([^\"]*)\" y un salario mayor a \"([^\"]*)\"$")
    public void seListanEmpleadosConAlMenosYUnSalarioMayorA(int meses, int salario)  {
        ConexionBD.initConnection();
        ConexionBD.getEmployee(meses, salario);
    }
}
