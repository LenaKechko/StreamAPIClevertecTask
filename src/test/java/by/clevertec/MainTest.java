package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task16() {
        List<Student> students = Util.getStudents();
        List<Student> expectedResult = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() < 18)
                expectedResult.add(student);
        }
        expectedResult.sort(Comparator.comparing(Student::getSurname));
        assertEquals(expectedResult, Main.task16());
    }
}