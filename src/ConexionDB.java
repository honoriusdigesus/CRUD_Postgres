import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    public Connection getConnection(String dbName, String user, String password) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);
            System.out.println(connection == null ? "No connection":"Connection");

        }catch (Exception e) {
            System.out.printf("Error getting connection: "+e.getMessage());
        }
        return connection;
    }
}
