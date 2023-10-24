package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void task8() {
        List<Animal> animals = Util.getAnimals();
        animals.sort(Comparator.comparing(Animal::getBread));
        animals = animals.subList(0, 100);
        animals.sort(Comparator.comparing(Animal::getAge));
        int expectedResult = animals.get(99).getAge();
        assertEquals(expectedResult, Main.task8());
    }
}