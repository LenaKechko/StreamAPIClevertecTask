package by.clevertec;

import by.clevertec.model.Person;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task12() {
        List<Person> persons = Util.getPersons();
        List<Person> expectedResult = new ArrayList<>();
        for (Person person : persons) {
            int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
            if (person.getGender().equals("Male") &&
                    (age >= 18 && age <= 27)) {
                expectedResult.add(person);
            }
        }
        expectedResult.sort(Comparator.comparing(Person::getRecruitmentGroup));
        if (expectedResult.size() > 200)
            expectedResult = expectedResult.subList(0, 200);
        assertEquals(expectedResult, Main.task12());
    }
}