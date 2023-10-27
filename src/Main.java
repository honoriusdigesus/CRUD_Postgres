import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConexionDB db= new ConexionDB();
        Connection connection = db.getConnection("ejercicio_crud","postgres","postgres");
        //db.insertDates(connection,"persona",1104381769,"Mary Cruz","Correa Paredes",28,"maryccorrea0117@gmail.com");
        db.selectDates(connection,"persona");
        db.updateDates(connection,"persona",1104377381,"Honorio de Jesús","Jaramillo Ortega",35,"jaramilloortega@gmail.com");
        db.selectDates(connection,"persona");

    }
}