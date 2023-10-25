package by.clevertec;

import by.clevertec.model.Flower;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task15() {
        List<Flower> flowers = Util.getFlowers();
        long countDaysOfFiveYears = 5 * 365 + 1;
        double expectedResult = 0.0;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        for (Flower flower : flowers) {
            if (flower.getCommonName().matches("[C-S].+")) {
                if (flower.isShadePreferred() && (
                        flower.getFlowerVaseMaterial().contains("Aluminum") ||
                                flower.getFlowerVaseMaterial().contains("Glass") ||
                                flower.getFlowerVaseMaterial().contains("Steel"))) {
                    expectedResult += flower.getPrice() + flower.getWaterConsumptionPerDay() * 1.39 / 1000 * countDaysOfFiveYears;
                }
            }
        }
        Main.task15();
        String textExpected = String.format("Общая стоимость обслуживания растений (за 5 лет) = %.2f $", expectedResult);
        assertEquals(textExpected, output.toString());
    }
}