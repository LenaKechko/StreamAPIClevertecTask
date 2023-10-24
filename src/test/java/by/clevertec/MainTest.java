package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    @Test
    void task7() {
        List<Animal> animals = Util.getAnimals();
        boolean expectedResult = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Oceania"))
                .findFirst()
                .isEmpty();
        assertEquals(expectedResult, Main.task7());
    }
}