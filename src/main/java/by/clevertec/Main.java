package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
//        persons.stream() Продолжить ...
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static double task14() {
        List<Car> cars = Util.getCars();
        Map<Boolean, List<Car>> tempTurk = cars.stream()
                .collect(Collectors.partitioningBy(
                        car -> car.getCarMake().equals("Jaguar")
                                || car.getColor().equals("White")));
        Map<String, List<Car>> carsEchelons = new HashMap<>();
        carsEchelons.put("Туркменистан", tempTurk.get(true));

        Map<Boolean, List<Car>> tempUsb = tempTurk.get(false).stream()
                .collect(Collectors.partitioningBy(
                        car -> car.getMass() < 1500 || //&& ???
                                (car.getCarMake().equals("BMW")
                                        || car.getCarMake().equals("Lexus")
                                        || car.getCarMake().equals("Chrysler")
                                        || car.getCarMake().equals("Toyota "))));
        carsEchelons.put("Узбекистан", tempUsb.get(true));

        Map<Boolean, List<Car>> tempKaz = tempUsb.get(false).stream()
                .collect(Collectors.partitioningBy(
                        car -> car.getColor().equals("Black") && car.getMass() > 4000 ||
                                (car.getCarMake().equals("GMC")
                                        || car.getCarMake().equals("Dodge"))));
        carsEchelons.put("Казахстан", tempKaz.get(true));

        Map<Boolean, List<Car>> tempKir = tempKaz.get(false).stream()
                .collect(Collectors.partitioningBy(
                        car -> car.getReleaseYear() < 1982 ||
                                (car.getCarMake().equals("Civic")
                                        || car.getCarMake().equals("Cherokee"))));
        carsEchelons.put("Кыргызстан", tempKir.get(true));

        Map<Boolean, List<Car>> tempRus = tempKir.get(false).stream()
                .collect(Collectors.partitioningBy(
                        car -> !(car.getColor().equals("Yellow") ||
                                car.getColor().equals("Red") ||
                                car.getColor().equals("Green") ||
                                car.getColor().equals("Blue")) ||
                                car.getPrice() > 40000));
        carsEchelons.put("Россия", tempRus.get(true));

        Map<Boolean, List<Car>> tempMong = tempRus.get(false).stream()
                .collect(Collectors.partitioningBy(
                        car -> car.getVin().contains("59")));
        carsEchelons.put("Монголия", tempMong.get(true));
        Map<String, Double> transactionCostIncludingDirection = new HashMap<>(Collections.emptyMap());
        carsEchelons.entrySet()
                .stream()
                .toList()
                .stream()
                .map(el ->
                        {
                            double transactionCost = getSumMass(el.getValue()) / 1000.0 * 7.14;
                            return Map.entry(el.getKey(), transactionCost);
                        }
                )
                .forEach(el -> transactionCostIncludingDirection.put(el.getKey(), el.getValue()));
        for (Map.Entry<String, Double> item : transactionCostIncludingDirection.entrySet()) {
            System.out.printf("%s - %f\n", item.getKey(), item.getValue());
        }
        double totalSum = transactionCostIncludingDirection.entrySet().stream()
                .map(Map.Entry::getValue)
                .reduce(0.0, Double::sum);
        System.out.println(totalSum);
        return totalSum;
    }

    public static long getSumMass(List<Car> carsList) {
        return carsList.stream()
                .reduce(0, (x, y) -> x + y.getMass(), Integer::sum);
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
