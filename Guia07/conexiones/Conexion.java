package conexiones;
import java.sql.*;


public class Conexion {

    //campos
    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String ingresoempleados = "";

    //Constructor
    public Conexion() throws SQLException {
        try
        {
            //Obtenemos el driver para mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Se obtiene una conexión de la base de datos
            conexion = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/personabdd","root","");
            s = conexion.createStatement();

            System.out.println("Conexion establecida ");
        }

        catch (ClassNotFoundException e1)
        {
            //Error si no puedo leer el driver de MySQL
            System.out.println("Error al conectar con el driver de la BD" +
                    e1.getMessage());
        }
    }

    //Metodo que permite obtener los valores del resulset
    public ResultSet getRs() {
        return rs;
    }

    //Metodo que permite fijar la tabla de resultado de la pregunta
    //sql realizada
    public void setRs(String sql) {
        try
        {
            this.rs = s.executeQuery(sql);
        }

        catch (SQLException e2)
        {
            //Error SQL: Login/psswd ó sentencia sql errónea
            System.out.println("ERROR:Fallo en SQL" + e2.getMessage());
        }
    }

    //Metodo que recibe un sql como parámetro que sea un update, insert.delete
    public void setQuery(String sql) throws SQLException {
        this.s.executeQuery(sql);
    }

    //Metodo que cierra la conexión
    public void cerrarConexion() throws SQLException
    {
        conexion.close();
    }

}
