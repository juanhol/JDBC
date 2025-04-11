package Model.Implementations;

import Model.Interfaces.IStudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private Connection connection;


    @Override
    public void delete(int id) {

    }

    @Override
    public void modify(int id) {

    }

    @Override
    public List toList() {
        List<Student> studentsList=new ArrayList<>();
        String sql="SELECT * FROM alumnos";
        try (Connection connection=MySQLConnection.getInstance().getConnection();
        PreparedStatement stmt=connection.prepareStatement(sql);
             ResultSet rS=stmt.executeQuery()){
            while (rS.next()){
                Student student=new Student();
                student.setId(rS.getInt("id"));
                student.setNombre(rS.getString("nombre"));
                student.setApellido(rS.getString("apellido"));
                student.setEdad(rS.getInt("edad"));
                student.setEmail(rS.getString("email"));

                studentsList.add(student);
            }
        }
        catch (SQLException e) {
            System.out.println("Failed to retrieve students: "+e.getMessage());
        }
        return studentsList;
    }

    @Override
    public void insert(Student student){
        String SQL="INSERT INTO alumnos(nombre,apellido,edad,email) VALUES(?,?,?,?)";

        try (
                Connection connection = MySQLConnection.getInstance().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQL)
        ){
            stmt.setString(1,student.getNombre());
            stmt.setString(2, student.getApellido());
            stmt.setInt(3,student.getEdad());
            stmt.setString(4,student.getEmail());

            stmt.executeUpdate();
            System.out.println("Student successfully inserted.");
        }
        catch(SQLException e){
            System.out.println("Failed to insert student"+e.getMessage());
        }
    }
}
