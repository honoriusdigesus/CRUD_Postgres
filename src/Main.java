import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConexionDB db= new ConexionDB();
        Connection connection = db.getConnection("ejercicio_crud","postgres","postgres");
        db.insertDates(connection,"persona",1104377381,"Honorius di Gesus","Jaramillo Ortega",34,"honorioconhache@gmail.com");
        db.selectDates(connection,"persona");
        db.updateDates(connection,"persona",1104377381,"Honorio de Jesús","Jaramillo Ortega",35,"jaramilloortega@gmail.com");
        db.deleteDates(connection,"persona",1104377381);
        db.selectDates(connection,"persona");
        db.selectID(connection,"persona",1104381769);

    }
}