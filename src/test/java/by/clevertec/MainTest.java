package by.clevertec;

import by.clevertec.model.Examination;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<String, Double> expectedResult = new HashMap<>();
        Map<String, List<Integer>> temp = new HashMap<>();
        for (Student student : students) {
            String faculty = student.getFaculty();
            List<Integer> aboutMarks = List.of(0, 0);
            if (temp.containsKey(faculty)) {
                aboutMarks = temp.get(faculty);
            }
            for (Examination examination : examinations) {
                if (examination.getStudentId() == student.getId()) {
                    aboutMarks = List.of(aboutMarks.get(0) + examination.getExam1(),
                            aboutMarks.get(1) + 1);
                }
            }
            temp.put(faculty, aboutMarks);
        }
        Map<String, Double> finalExpectedResult = new HashMap<>();

        temp.forEach((faculty, value) -> {
            double averageMark = (double) value.get(0) / value.get(1);
            expectedResult.put(faculty, averageMark);
        });
        finalExpectedResult = expectedResult.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        assertEquals(finalExpectedResult, Main.task20());
    }
}