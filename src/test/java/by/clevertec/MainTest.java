package by.clevertec;

import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task18() {
        List<Student> students = Util.getStudents();
        Map<String, Double> expectedResult = new HashMap<>();
        Map<String, List<Integer>> temp = new HashMap<>();
        for (Student student : students) {
            String faculty = student.getFaculty();
            List<Integer> tempData = List.of(0, 0);
            if (temp.containsKey(faculty)) {
                tempData = temp.get(faculty);
            }
            int sumAge = tempData.get(0) + student.getAge();
            int countStudent = tempData.get(1) + 1;
            tempData = List.of(sumAge, countStudent);
            temp.put(faculty, tempData);
        }
        for (Map.Entry<String, List<Integer>> el : temp.entrySet()) {
            int sumAge = el.getValue().get(0);
            int countStudent = el.getValue().get(1);
            expectedResult.put(el.getKey(), (double) sumAge / countStudent);
        }
        expectedResult = expectedResult.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));;
        assertEquals(expectedResult, Main.task18());
    }
}