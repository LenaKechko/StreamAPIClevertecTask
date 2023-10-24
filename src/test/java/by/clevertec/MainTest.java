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
    void task21() {
        List<Student> students = Util.getStudents();
        Map<String, Long> expectedResult = new HashMap<>();
        for (Student student : students) {
            String group = student.getGroup();
            long countStudent = 0;
            if (expectedResult.containsKey(group)) {
                countStudent = expectedResult.get(group);
            }
            expectedResult.put(group, ++countStudent);
        }
        assertEquals(expectedResult, Main.task21());
    }
}