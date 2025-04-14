package Model.Interfaces;

import Model.Exceptions.UnexistantStudentException;
import Model.Implementations.Direction;
import Model.Implementations.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IDirectionsDAO {
    void delete(int id);
    void modify(int id);
    ArrayList<Direction> toListByStudentId(int StudentId) throws SQLException;
    void insert(Direction direction);
}
