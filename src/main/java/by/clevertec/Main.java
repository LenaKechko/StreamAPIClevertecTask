package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
        Set<Person> resultList = new LinkedHashSet<>();
//        houses.stream().spliterator().forEachRemaining(System.out::println);
//        Map<Boolean, List<House>> listPriority =
        houses.stream()
                .collect(Collectors.partitioningBy(house ->
                        house.getBuildingType().equals("Hospital")))
                .entrySet().stream()
                .peek(el -> {
                    if (el.getKey()) {
                        el.getValue().stream()
                                .map(House::getPersonList)
                                .flatMap(Collection::stream)
                                .forEach(resultList::add);
                    }
                })
                .filter(el -> !el.getKey())
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .map(House::getPersonList)
                .flatMap(Collection::stream)
                .collect(Collectors.partitioningBy(person ->
                        (Period.between(person.getDateOfBirth(),
                                LocalDate.now()).getYears() < 18 ||
                                Period.between(person.getDateOfBirth(),
                                        LocalDate.now()).getYears() > 63)))
                .entrySet().stream()
                .peek(el -> {
                    if (el.getKey()) {
                        resultList.addAll(el.getValue());
                    }
                })
                .filter(el -> !el.getKey())
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .forEach(resultList::add);

        System.out.println("Result!");
        resultList.forEach(System.out::println);
//        System.out.println(resultList.stream().limit(500));
        //992 - 42/999
//                .forEachRemaining(System.out::println);
//        ;
//        .flatMap(Collection::parallelStream)
//        List<House> firstWave = listPriority.get(true);
//        listPriority.get(false).stream().

//        System.out.println(firstWave);
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
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
