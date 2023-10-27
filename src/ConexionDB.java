import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionDB {
    Connection connection = null;
    Statement statement = null;
    public Connection getConnection(String dbName, String user, String password) {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);
            System.out.println(connection == null ? "No connection":"Connection");

        }catch (Exception e) {
            System.out.printf("Error getting connection: "+e.getMessage());
        }
        return connection;
    }

    //Insertar datos en la tabla
    public void insertDates(Connection connection, String nameTable, Integer di, String name, String lastName, Integer age, String email){
        try {
            String query = String.format("INSERT INTO %s(di, name, lastname, age, email) values ('%s','%s','%s','%s','%s');", nameTable, di, name, lastName, age, email);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Dates inserts");
        } catch (Exception e) {
            System.out.printf("Error inserting data: "+e.getMessage());
        }
    }
}
