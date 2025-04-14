import Model.Implementations.Student;
import Model.Implementations.StudentDAO;
import Model.Implementations.StudentsService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentsService service=new StudentsService();
        StudentDAO studentDAO=new StudentDAO();

        studentDAO.updateAge(1,23);
        service.ShowStudentsWithDirections();

    }
}