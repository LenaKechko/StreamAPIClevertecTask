package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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

    @Test
    void task4() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        System.setOut(new PrintStream(outputStream));
        long exceptedResult = 0;
        List<Animal> animals = Util.getAnimals();
        for (Animal animal : animals) {
            if (animal.getGender().equals("Female")) exceptedResult++;
        }
        Main.task4();
        String exceptedResultConsole = String.format("Количество Female-животных: " + exceptedResult);
        assertEquals(exceptedResultConsole, outputStream.toString().trim());
    }

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

    @Test
    void task7() {

    }
    @Test
    void task8() {

    }
    @Test
    void task9() {

    }
    @Test
    void task10() {

    }
    @Test
    void task11() {

    }
    @Test
    void task12() {

    }
    @Test
    void task13() {

    }
    @Test
    void task14() {

    }
    @Test
    void task15() {

    }
    @Test
    void task16() {

    }
    @Test
    void task17() {

    }
    @Test
    void task18() {

    }
    @Test
    void task19() {

    }
    @Test
    void task20() {

    }
    @Test
    void task21() {

    }
    @Test
    void task22() {

    }
}