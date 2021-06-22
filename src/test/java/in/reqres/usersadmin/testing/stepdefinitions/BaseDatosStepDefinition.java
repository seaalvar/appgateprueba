package in.reqres.usersadmin.testing.stepdefinitions;

import cucumber.api.java.en.When;
import in.reqres.usersadmin.testing.models.Empleado;
import in.reqres.usersadmin.testing.utils.ManageBD;

import java.sql.SQLException;
import java.util.List;


public class BaseDatosStepDefinition {

    @When("^se crea el empleado en la base de datos")
    public void seCreaElEmpleadoEnLaBaseDeDatos(List<Empleado> listaEmpleado) throws SQLException {
        ManageBD.initConnection();
        for(int i=0; i <listaEmpleado.size(); i++){
            ManageBD.insertEmployee(listaEmpleado.get(i).getIdEmpleado(),
                                    listaEmpleado.get(i).getNombre(),
                                    listaEmpleado.get(i).getMeses(),
                                    listaEmpleado.get(i).getSalario());
        }
        ManageBD.closeConnection();
    }

    @When("^se listan empleados con menos de \"([^\"]*)\" y un salario mayor a \"([^\"]*)\"$")
    public void seListanEmpleadosConMenosdeYUnSalarioMayorA(int meses, int salario)  {
        ManageBD.initConnection();
        ManageBD.getEmployee(meses, salario);
        ManageBD.closeConnection();
    }
}
