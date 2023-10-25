package by.clevertec;

import by.clevertec.model.Examination;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        List<Student> expectedResult = new ArrayList<>();
        String group = "C-3";
        for (Student student : students) {
            if (student.getGroup().equals(group)) {
                for (Examination examination : examinations) {
                    if (student.getId() == examination.getStudentId() && examination.getExam3() > 4)
                        expectedResult.add(student);
                }
            }
        }
        assertEquals(expectedResult, Main.task19());
    }
}