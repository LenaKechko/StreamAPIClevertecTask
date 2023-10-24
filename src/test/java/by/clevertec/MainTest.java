package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task1() {
        List<Animal> animals = Util.getAnimals();
        int countAnimalsInZoo = 7;
        List<Animal> expectedList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() >= 10 && animal.getAge() <= 20) {
                expectedList.add(animal);
            }
        }
        expectedList.sort(Comparator.comparing(Animal::getAge));
        expectedList = expectedList.subList(2 * countAnimalsInZoo, 3 * countAnimalsInZoo);
        assertEquals(expectedList, Main.task1());
    }
}