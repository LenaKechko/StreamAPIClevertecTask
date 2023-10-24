package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

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
}