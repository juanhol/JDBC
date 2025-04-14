package Model.Interfaces;

import Model.Implementations.Student;

import java.util.ArrayList;
import java.util.List;

public interface IStudentDAO {
    void delete(int id);
    void updateAge(int id, int age);
    ArrayList<Student> toList();
    void insert(Student student);


}
