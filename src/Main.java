import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConexionDB db= new ConexionDB();
        db.getConnection("ejercicio_crud","postgres","postgres");

    }
}