package in.reqres.usersadmin.testing.models;

public class Empleado {

    private int idEmpleado;
    private String nombre;
    private int meses;
    private int salario;

    public Empleado(int idEmpleado, String nombre, int meses, int salario){
        super();
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.meses = meses;
        this.salario = salario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMeses() {
        return meses;
    }

    public int getSalario() {
        return salario;
    }
}
