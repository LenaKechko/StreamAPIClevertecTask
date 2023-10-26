package by.clevertec.util;

import by.clevertec.model.Car;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyPredicate {

    public static Predicate<Car> isFirstEchelon() {
        return car -> car.getCarMake().equals("Jaguar") || car.getColor().equals("White");
    }

    public static Predicate<Car> isSecondEchelon() {
        return car -> car.getMass() < 1500 &&
                (car.getCarMake().equals("BMW")
                        || car.getCarMake().equals("Lexus")
                        || car.getCarMake().equals("Chrysler")
                        || car.getCarMake().equals("Toyota "));
    }

    public static Predicate<Car> isThirdEchelon() {
        return car ->
                (car.getColor().equals("Black") && car.getMass() > 4000)
                        || car.getCarMake().equals("GMC")
                        || car.getCarMake().equals("Dodge");
    }

    public static Predicate<Car> isFourthEchelon() {
        return car -> car.getReleaseYear() < 1982
                || car.getCarMake().equals("Civic")
                || car.getCarMake().equals("Cherokee");
    }

    public static Predicate<Car> isFifthEchelon() {
        return car -> !(car.getColor().equals("Yellow") ||
                car.getColor().equals("Red") ||
                car.getColor().equals("Green") ||
                car.getColor().equals("Blue")) ||
                car.getPrice() > 40000;
    }

    public static Predicate<Car> isSixthEchelon() {
        return car -> car.getVin().contains("59");
    }

    public static List<Car> filterCars(List<Car> cars, Predicate<Car> predicate) {
        return cars.stream()
                .filter(predicate)
                .collect(Collectors.<Car>toList());
    }
}
