package util;
import java.sql.*;

public class Conexion {
    // Valores de conexion a MySQL
    private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    // EL puerto es opcional
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/personabdd";
    private static String JDBC_USER = "root";
    private static String JDBC_PASS = "";
    private static Driver driver = null;

    // Para que no haya problemas al obtener la conexion de
    // manera concurrente, se usa la palabra synchronized
    public static synchronized Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch (Exception e) {
            System.out.println("Fallo en cargar el driver JDBC");
            e.printStackTrace();
            return null;
        }
    }

    // Cierre del resultSet
    public static void close(ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    // Cierre del PreparedStatement
    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    // Cierre de la conexion
    public static void close(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
