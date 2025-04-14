package Model.Implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsService {
    public void ShowStudentsWithDirections() throws SQLException {
        StudentDAO studentDAO=new StudentDAO();
        DirectionsDAO directionsDAO=new DirectionsDAO();

        ArrayList<Student> students=studentDAO.toList();
        for (Student s:students){
            System.out.println("Student: "+s.getNombre()+" "+s.getApellido());
            System.out.println("Id: "+s.getId());
            System.out.println("Age: "+s.getEdad());
            System.out.println("Email: "+s.getEmail());
            ArrayList<Direction> directions=directionsDAO.toListByStudentId(s.getId());
            System.out.println("Directions: ");
            if (!directions.isEmpty()){

                for (Direction d:directions){
                    System.out.println(d.getCalle()+" "+d.getAltura());
                }
            }
            else
                System.out.println("No directions assigned");
        }
    }
}
