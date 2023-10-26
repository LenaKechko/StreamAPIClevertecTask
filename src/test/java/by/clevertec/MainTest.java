package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void task2() {
        List<Animal> animals = Util.getAnimals();
        List<String> expectedList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getOrigin().equals("Japanese") && animal.getGender().equals("Female"))
                expectedList.add(animal.getBread().toUpperCase());
        }
        assertEquals(expectedList, Main.task2());
    }

    @Test
    void task3() {
        List<String> expectedList = List.of("Azeri", "Aymara", "Afrikaans",
                "Arabic", "Armenian", "Amharic", "Assamese", "Albanian");
        assertEquals(expectedList, Main.task3());
    }
}