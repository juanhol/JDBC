package Model.Interfaces;

import Model.Implementations.Student;

import java.util.List;

public interface IStudentDAO {
    void delete(int id);
    void modify(int id);
    List toList();
    void insert(Student student);


}
