package in.reqres.usersadmin.testing.utils;

import in.reqres.usersadmin.testing.exceptions.ConnectionError;

import java.sql.*;

public class ManageBD {

    private static String user = "postgres";
    private static String pass = "p4ssw0rd";
    private static Connection connection;

    /**
     * Método encargado de abrir la conexión con la base dew datos
     */
    public static void initConnection() {
       try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/appgate", user, pass);
        }
       catch (SQLException e) {
           throw new ConnectionError("Failed to connect to server");
        }
    }

    /**
     * Método encargado de cerrar la conexión con la base dew datos
     */
    public static void closeConnection(){
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Metodo encargado de insertar usuarios en la base de datos
     * @param idEmpleado
     * @param nombre
     * @param meses
     * @param salario
     */
    public static void insertEmployee(int idEmpleado, String nombre, int meses, int salario) throws SQLException {
        try{
            PreparedStatement stmn = connection.prepareStatement("insert into empleados (idempleado,nombre,meses,salario) values (?,?,?,?)");
            stmn.setInt(1,idEmpleado);
            stmn.setString(2,nombre);
            stmn.setInt(3,meses);
            stmn.setInt(4,salario);

            stmn.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo encargado de consultar usuarios en la base de datos
     * @param meses
     * @param salario
     */
    public static void getEmployee(int meses, int salario) {

        try {
            PreparedStatement stmn = connection.prepareStatement("select * from empleados where meses <= ? and salario >= ?");
            stmn.setInt(1,meses);
            stmn.setInt(2,salario);
            ResultSet result = stmn.executeQuery();

            System.out.println("idEmpleado | nombre | meses | salario");
            while (result.next()) {
                int idmpleado = result.getInt("idempleado");
                String nombre = result.getString("nombre");
                int meses1 = result.getInt("meses");
                int salario1 = result.getInt("salario");

                System.out.println(idmpleado + " \t" + nombre + " \t" + meses1 + " \t" + salario1);
            }
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

}
