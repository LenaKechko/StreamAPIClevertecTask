package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task11() {
        List<Animal> animals = Util.getAnimals();
        int countAnimals = 0;
        int sumAgeAnimals = 0;
        for (Animal animal : animals) {
            if (animal.getOrigin().equals("Indonesian")) {
                sumAgeAnimals += animal.getAge();
                countAnimals++;
            }
        }
        double exceptedResult = (double) sumAgeAnimals / countAnimals;
        assertEquals(exceptedResult, Main.task11());
    }
}