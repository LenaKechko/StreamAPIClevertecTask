package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.util.Comparator;
import java.util.List;
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

    public static List<Animal> task1() {
        List<Animal> animals = Util.getAnimals();
        int countAnimalsInZoo = 7;
        List<Animal> animalInThirdZoo = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(2 * countAnimalsInZoo)
                .limit(countAnimalsInZoo)
                .collect(Collectors.toList());
        System.out.println("Молодые особи с 3-ом зоопарке:");
        animalInThirdZoo.forEach(System.out::println);
        return animalInThirdZoo;
    }

    public static List<String> task2() {
        List<Animal> animals = Util.getAnimals();
        List<String> breadsAnimals = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese")
                        && animal.getGender().equals("Female"))
                .map(animal -> animal.getBread().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Породы животных из Японии (самки прописными буквами):");
        breadsAnimals.forEach(System.out::println);
        return breadsAnimals;
    }

    public static List<String> task3() {
        List<Animal> animals = Util.getAnimals();
        List<String> originAnimals = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .distinct()
                .filter(origin -> origin.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Страны на букву А, в которых проживают животные старше 30 лет");
        originAnimals.forEach(System.out::println);
        return originAnimals;
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        long countFemaleAnimals = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println("Количество Female-животных: " + countFemaleAnimals);
    }

    public static List<Animal> task5() {
        List<Animal> animals = Util.getAnimals();
        List<Animal> animalsFromHungarianAndAge = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .filter(animal -> animal.getOrigin().equals("Hungarian"))
                .toList();
        System.out.println("Животные из Венгрии в возрасте 20-30 лет:");
        animalsFromHungarianAndAge.forEach(System.out::println);
        return animalsFromHungarianAndAge;
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
