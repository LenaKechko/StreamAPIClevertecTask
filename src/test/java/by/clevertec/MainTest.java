package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task9() {
        List<Animal> animals = Util.getAnimals();
        int expectedResult = animals.stream()
                .map(Animal::getBread)
                .map(String::length)
                .min(Integer::compareTo)
                .orElseThrow();
        assertEquals(expectedResult, Main.task9());
    }
}