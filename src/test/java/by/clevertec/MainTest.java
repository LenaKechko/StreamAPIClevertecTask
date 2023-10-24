package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    @Test
    void task17() {
        List<Student> students = Util.getStudents();
        List<String> expectedList = new ArrayList<>();
        for (Student student : students) {
            if (expectedList.contains(student.getGroup()))
                continue;
            expectedList.add(student.getGroup());
        }
        assertEquals(expectedList, Main.task17());
    }
}