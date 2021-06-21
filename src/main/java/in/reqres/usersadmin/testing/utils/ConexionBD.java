package in.reqres.usersadmin.testing.utils;

import java.sql.*;

public class ConexionBD {

    private static String user = "postgres";
    private static String pass = "p4ssw0rd";
    private static Connection connection;

    public static void initConnection() {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/appgate", user, pass);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

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
