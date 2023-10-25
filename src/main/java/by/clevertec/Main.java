package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.MyPredicate;
import by.clevertec.util.Util;

import java.util.ArrayList;
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
        Map<String, List<Car>> result =
                Map.of("Туркменистан", new ArrayList<>(),
                        "Узбекистан", new ArrayList<>(),
                        "Казахстан", new ArrayList<>(),
                        "Кыргызстан", new ArrayList<>(),
                        "Россия", new ArrayList<>(),
                        "Монголия", new ArrayList<>());
        Map<String, List<Car>> echelonesList = new HashMap<>();
        System.out.println(cars.stream()
                .map(car ->
                        {
                            echelonesList.put("Туркменистан", MyPredicate.filterCars(cars, MyPredicate.isFirstEchelon()));
                            echelonesList.put("Узбекистан", MyPredicate.filterCars(cars, MyPredicate.isSecondEchelon()));
                            echelonesList.put("Казахстан", MyPredicate.filterCars(cars, MyPredicate.isThirdEchelon()));
                            echelonesList.put("Кыргызстан", MyPredicate.filterCars(cars, MyPredicate.isFourthEchelon()));
                            echelonesList.put("Россия", MyPredicate.filterCars(cars, MyPredicate.isFifthEchelon()));
                            echelonesList.put("Монголия", MyPredicate.filterCars(cars, MyPredicate.isSixthEchelon()));
                            return echelonesList;
                        }
                )
                .count());
//                .map(el ->
//                        {
//                            double transactionCost = Main.getSumMass(el.getValue()) / 1000.0 * 7.14;
//                            return Map.entry(el.getKey(), transactionCost);
//                        }
//                )
//                .forEach(el -> transactionCostIncludingDirection.put(el.getKey(), el.getValue()));
//MyPredicate.isSecondEchelon().and(MyPredicate.isFirstEchelon().negate())
//        return totalSum;
        return 0.0;
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
