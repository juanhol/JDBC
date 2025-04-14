package Model.Implementations;

import Model.Exceptions.UnexistantStudentException;
import Model.Interfaces.IDirectionsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public ArrayList<Direction> toListByStudentId(int StudentId) throws SQLException {
        ArrayList<Direction> directions=new ArrayList<>();
        String sql="SELECT * FROM direcciones WHERE alumno_id=?";
        connection=MySQLConnection.getInstance().getConnection();

        try (PreparedStatement stmt= connection.prepareStatement(sql);
        ){
            stmt.setInt(1,StudentId);
            ResultSet rs= stmt.executeQuery();

            while (rs.next()){
                Direction direction=new Direction();
                direction.setAltura(rs.getInt("altura"));
                direction.setCalle(rs.getString("calle"));
                direction.setId(rs.getInt("id"));
                direction.setAlumno_id(rs.getInt("alumno_id"));

                directions.add(direction);
            }

        }
        catch (SQLException e){
            System.out.println("Failed to retrieve directions"+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Directions successfully retrieved");
        return directions;
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
