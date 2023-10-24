package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task6() {
        List<Animal> animals = Util.getAnimals();
        boolean expectedResult = animals.stream()
                .map(Animal::getGender)
                .distinct()
                .allMatch(gender -> gender.equals("Male")
                        || gender.equals("Female"));
        assertEquals(expectedResult, Main.task6());
    }
}