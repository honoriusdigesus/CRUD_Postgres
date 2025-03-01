import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

    //Ver todos los datos de la tabla
    public void selectDates(Connection connection, String nameTable){
        try {
            String query = String.format("SELECT * FROM %s;", nameTable);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("di") + " " + rs.getString("name") + " " + rs.getString("lastname") + " " + rs.getString("age") + " " + rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.printf("Error selecting data: "+e.getMessage());
        }
    }

    //Actualizar datos en la tabla
    public void updateDates(Connection connection, String nameTable, Integer di, String name, String lastName, Integer age, String email){
        try {
            String query = String.format("UPDATE %s SET di = '%s', name = '%s', lastname = '%s', age = '%s', email = '%s' WHERE di = '%s';", nameTable, di, name, lastName, age, email, di);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Dates updated");
        } catch (Exception e) {
            System.out.printf("Error updating data: "+e.getMessage());
        }
    }

    //Eliminar datos de la tabla
    public void deleteDates(Connection connection, String nameTable, Integer di){
        try {
            String query = String.format("DELETE FROM %s WHERE di = '%s';", nameTable, di);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Dates deleted");
        } catch (Exception e) {
            System.out.printf("Error deleting data: "+e.getMessage());
        }
    }

    //Buscar por ID de la tabla
    public void selectID(Connection connection, String nameTable, Integer di){
        try {
            String query = String.format("SELECT * FROM %s WHERE di = '%s';", nameTable, di);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("di") + " " + rs.getString("name") + " " + rs.getString("lastname") + " " + rs.getString("age") + " " + rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.printf("Error selecting data: "+e.getMessage());
        }
    }
}
