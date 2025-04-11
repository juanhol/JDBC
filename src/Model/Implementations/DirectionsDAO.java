package Model.Implementations;

import Model.Exceptions.UnexistantStudentException;
import Model.Interfaces.IDirectionsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DirectionsDAO implements IDirectionsDAO {
    private Connection connection;


    @Override
    public void delete(int id) {

    }

    @Override
    public void modify(int id) {

    }

    @Override
    public List toList() {
        return List.of();
    }

    @Override
    public void insert(Direction direction) {
        String sql="INSERT INTO direcciones(calle,altura,alumno_id)VALUES(?,?,?)";

        try (Connection connection=MySQLConnection.getInstance().getConnection();
             PreparedStatement stmt= connection.prepareStatement(sql)){
            if(!verifyStudent(direction.getAlumno_id())){
                throw new UnexistantStudentException("");
            }
            stmt.setString(1, direction.getCalle());
            stmt.setInt(2,direction.getAltura());
            stmt.setInt(3,direction.getAlumno_id());

            stmt.executeUpdate();
            System.out.println("Direction successfully inserted");

        } catch (SQLException | UnexistantStudentException e) {
            System.out.println("Failed to insert student"+e.getMessage());
        }
    }
    public boolean verifyStudent(int StudentId){
        String sql="SELECT id FROM alumnos WHERE id=?";
        try (Connection connection=MySQLConnection.getInstance().getConnection();
                PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setInt(1,StudentId);
            ResultSet rs= stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
