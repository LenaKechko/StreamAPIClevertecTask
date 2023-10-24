package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    @Test
    void task10() {
        List<Animal> animals = Util.getAnimals();
        long expectedResult = 0;
        for (Animal animal : animals) {
            expectedResult += animal.getAge();
        }
        assertEquals(expectedResult, Main.task10());
    }
}