package by.clevertec;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void task3() {
        List<String> expectedList = List.of("Azeri", "Aymara", "Afrikaans",
                "Arabic", "Armenian", "Amharic", "Assamese", "Albanian");
        assertEquals(expectedList, Main.task3());
    }
}