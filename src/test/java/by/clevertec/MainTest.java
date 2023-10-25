package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task22() {
        List<Student> students = Util.getStudents();
        Map<String, Integer> expectedResult = new HashMap<>();
        for (Student student : students) {
            int minAge = Integer.MAX_VALUE;
            String faculty = student.getFaculty();
            if (expectedResult.containsKey(faculty))
                minAge = expectedResult.get(faculty);
            if (minAge > student.getAge())
                minAge = student.getAge();
            expectedResult.put(faculty, minAge);
        }
        assertEquals(expectedResult, Main.task22());
    }
}