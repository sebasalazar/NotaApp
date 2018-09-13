package cl.utem.inf.nota.manager;

import cl.utem.inf.nota.model.Student;
import java.util.List;

public interface StudentManager {

    public Student getStudent(Long id);

    public Student getStudent(String email);

    public List<Student> getStudents();

    public List<Student> getStudents(String lastName);

    public Student save(Student student);

    public boolean delete(Student student);
}
