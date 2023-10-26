package by.clevertec;

import by.clevertec.model.Car;
import by.clevertec.util.Util;
import by.clevertec.util.UtilForTask14;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task14() {
        List<Car> cars = Util.getCars();
        List<Car> tempTurk = new ArrayList<>();
        List<Car> tempUsb = new ArrayList<>();
        List<Car> tempKaz = new ArrayList<>();
        List<Car> tempKur = new ArrayList<>();
        List<Car> tempRos = new ArrayList<>();
        List<Car> tempMong = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCarMake().equals("Jaguar")
                    || car.getColor().equals("White")) {
                tempTurk.add(car);
            } else if (car.getMass() < 1500 &&
                    (car.getCarMake().equals("BMW")
                            || car.getCarMake().equals("Lexus")
                            || car.getCarMake().equals("Chrysler")
                            || car.getCarMake().equals("Toyota "))) {
                tempUsb.add(car);
            } else if ((car.getColor().equals("Black") && car.getMass() > 4000)
                    || car.getCarMake().equals("GMC")
                    || car.getCarMake().equals("Dodge")) {
                tempKaz.add(car);
            } else if (car.getReleaseYear() < 1982
                    || car.getCarMake().equals("Civic")
                    || car.getCarMake().equals("Cherokee")) {
                tempKur.add(car);
            } else if (!(car.getColor().equals("Yellow") ||
                    car.getColor().equals("Red") ||
                    car.getColor().equals("Green") ||
                    car.getColor().equals("Blue")) ||
                    car.getPrice() > 40000) {
                tempRos.add(car);
            } else if (car.getVin().contains("59")) {
                tempMong.add(car);
            }
        }
        Map<String, List<Car>> carsEchelons = new HashMap<>();
        carsEchelons.put("Туркменистан", tempTurk);
        carsEchelons.put("Узбекистан", tempUsb);
        carsEchelons.put("Казахстан", tempKaz);
        carsEchelons.put("Кыргызстан", tempKur);
        carsEchelons.put("Россия", tempRos);
        carsEchelons.put("Монголия", tempMong);
        double expectedResult = carsEchelons.entrySet()
                .stream()
                .map(el ->
                        {
                            double transactionCost = UtilForTask14.getSumMass(el.getValue()) / 1000.0 * 7.14;
                            double totalProfit = (double) UtilForTask14.getSumPrice(el.getValue()) - transactionCost;
                            return Map.entry(el.getKey(), totalProfit);
                        }
                )
                .map(Map.Entry::getValue)
                .reduce(0.0, Double::sum);
        assertEquals(expectedResult, Main.task14());
    }
}