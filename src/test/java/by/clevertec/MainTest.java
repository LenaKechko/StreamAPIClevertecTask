package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    @Test
    void task5() {
        List<Animal> animals = Util.getAnimals();
        List<Animal> expectedList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() >= 20 && animal.getAge() <= 30
                    && animal.getOrigin().equals("Hungarian"))
                expectedList.add(animal);
        }
        assertEquals(expectedList, Main.task5());
    }
}