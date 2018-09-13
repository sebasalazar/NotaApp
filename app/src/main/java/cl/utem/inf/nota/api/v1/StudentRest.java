package cl.utem.inf.nota.api.v1;

import cl.utem.inf.nota.ResponseVO;
import cl.utem.inf.nota.manager.StudentManager;
import cl.utem.inf.nota.model.Student;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentRest {

    @Autowired
    private StudentManager studentManager;

    @RequestMapping(value = "/lastName", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public ResponseEntity listByLastName(@RequestParam(value = "lastName") String lastName) {
        ResponseEntity response;

        if (StringUtils.isNotBlank(lastName)) {
            List<Student> students = studentManager.getStudents(lastName);
            if (students.isEmpty()) {
                response = new ResponseEntity(new ResponseVO(false, "No existen estudiantes con este criterio de búsqueda"), HttpStatus.NOT_FOUND);
            } else {
                response = new ResponseEntity(students, HttpStatus.OK);
            }
        } else {
            response = new ResponseEntity(new ResponseVO(false, "No viene un apellido válido"), HttpStatus.PRECONDITION_FAILED);
        }

        return response;
    }
}
