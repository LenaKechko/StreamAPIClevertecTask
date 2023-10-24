package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

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
}