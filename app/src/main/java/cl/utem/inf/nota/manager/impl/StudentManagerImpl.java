package cl.utem.inf.nota.manager.impl;

import cl.utem.inf.nota.manager.StudentManager;
import cl.utem.inf.nota.model.Student;
import cl.utem.inf.nota.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentManagerImpl implements StudentManager {

    @Autowired
    public transient StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        Student student = null;
        if (id != null && id > 0) {
            Optional<Student> findById = studentRepository.findById(id);
            student = findById.get();
        }
        return student;
    }

    @Override
    public Student getStudent(String email) {
        Student student = null;
        if (EmailValidator.getInstance().isValid(email)) {
            student = studentRepository.findByEmailIgnoreCase(email);
        }
        return student;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        if (students == null) {
            students = new ArrayList<>();
        }
        return students;
    }

    @Override
    public List<Student> getStudents(String lastName) {
        List<Student> students = new ArrayList<>();
        if (StringUtils.isNotBlank(lastName)) {
            students = studentRepository.findByLastNameIgnoreCase(lastName);
            if (students == null) {
                students = new ArrayList<>();
            }
        }
        return students;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        Student saved = null;
        if (student != null) {
            saved = studentRepository.save(student);
        }
        return saved;
    }

    @Override
    @Transactional
    public boolean delete(Student student) {
        boolean ok = false;
        if (student != null) {
            studentRepository.delete(student);
            ok = true;
        }
        return ok;
    }

}
