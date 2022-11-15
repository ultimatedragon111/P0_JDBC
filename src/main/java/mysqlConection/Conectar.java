package mysqlConection;

import java.sql.*;
import java.util.ArrayList;

import model.persona;

public class Conectar {


    public static final String SCHEMA_NAME = "act0";
    public static final String CONNECTION =
            "jdbc:mysql://localhost:3306/" +
                    SCHEMA_NAME +
                    "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    public static final String USER_CONNECTION = "root";
    public static final String PASS_CONNECTION = "root";
    public static Connection conexion;


    public static void main(String[] args) throws SQLException {
        connectar();
        /*persona prueba = new persona("743821","Raul","Gomez");
        insertNewPersona(prueba);*/
        System.out.println("=========");
        for (persona persona: getAll()){
            System.out.println("dni: " + persona.getDni() + " nombre: " + persona.getNombre() + " apellidos: " + persona.getApellidos() );
        }
        System.out.println("=========");
        desconectar();



    }
    public static void connectar() throws SQLException {
        String url = CONNECTION;
        String user = USER_CONNECTION;
        String pass = PASS_CONNECTION;
        conexion = DriverManager.getConnection(url, user, pass);
    }
    public static void desconectar() throws SQLException {
        if(conexion!=null){
            conexion.close();
        }
    }

    public static void insertNewPersona(persona persona) throws SQLException {
        try (PreparedStatement ps =  conexion.prepareStatement("insert into cliente (dni,name, surname) values (?,?,?)")) {
            ps.setString(1, persona.getDni());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellidos());
            ps.executeUpdate();
        }
    }

    public static ArrayList<persona> getAll() throws SQLException {
        ArrayList<persona> personaList = new ArrayList<>();

        try (Statement st = conexion.createStatement()) {
            try (ResultSet rs = st.executeQuery("select * from cliente")) {
                while(rs.next()){
                    persona persona = new persona(rs.getString(1), rs.getString(2), rs.getString(3));
                    personaList.add(persona);
                }
            }
        }
        return personaList;
    }


}
