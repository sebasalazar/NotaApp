package cl.utem.inf.nota.repository;

import cl.utem.inf.nota.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByEmailIgnoreCase(String email);

    public List<Student> findByLastNameIgnoreCase(String lastName);
}
