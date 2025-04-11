package Model.Interfaces;

import Model.Exceptions.UnexistantStudentException;
import Model.Implementations.Direction;
import Model.Implementations.Student;

import java.util.List;

public interface IDirectionsDAO {
    void delete(int id);
    void modify(int id);
    List toList();
    void insert(Direction direction);
}
