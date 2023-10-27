import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConexionDB db= new ConexionDB();
        Connection connection = db.getConnection("ejercicio_crud","postgres","postgres");
        db.insertDates(connection,"persona",1104377381,"Honorius di Gesus","Jaramillo Ortega",34,"honoriusdigesus@gmail.com");

    }
}