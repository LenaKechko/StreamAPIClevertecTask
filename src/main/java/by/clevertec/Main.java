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
import by.clevertec.util.UtilForTask14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import java.util.regex.Pattern;

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

    public static boolean task6() {
        List<Animal> animals = Util.getAnimals();
        boolean checkOtherGenderAnimal = animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male")
                        || animal.getGender().equals("Female"));
        System.out.println(checkOtherGenderAnimal ? "Все животные Female или Male" : "Не все животные Female или Male");
        return checkOtherGenderAnimal;
    }

    public static boolean task7() {
        List<Animal> animals = Util.getAnimals();
        boolean checkOrigin = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
        System.out.println(checkOrigin ? "Нет животных из страны Oceania" : "Есть животные из страны Oceania");
        return checkOrigin;
    }

    public static int task8() {
        List<Animal> animals = Util.getAnimals();
        int maxAge = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .map(Animal::getAge)
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println("Возраст самого старого животного после " +
                "сортировки породы и отбора первых 100: " + maxAge);
        return maxAge;
    }

    public static int task9() {
        List<Animal> animals = Util.getAnimals();
        int minLengthBread = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .map(bread -> bread.length)
                .min(Integer::compareTo)
                .orElseThrow();
        System.out.println("Длина самой короткой породы: " + minLengthBread);
        return minLengthBread;
    }

    public static int task10() {
        List<Animal> animals = Util.getAnimals();
        int sumAge = animals.stream()
                .reduce(0,
                        (partialAgeResult, animal) -> partialAgeResult + animal.getAge(),
                        Integer::sum);
        System.out.println("Суммарный возраст всех животных: " + sumAge);
        return sumAge;
    }

    public static double task11() {
        List<Animal> animals = Util.getAnimals();
        double avgAge = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .orElseThrow();
        System.out.println("Средний возраст животных из Indonesian: "+ avgAge);
        return avgAge;
    }

    public static List<Person> task12() {
        List<Person> persons = Util.getPersons();
        List<Person> personsRecruitment = persons.stream()
                .filter(person -> person.getGender().equals("Male") &&
                        (Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() >= 18
                                && Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() <= 27))
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .collect(Collectors.toList());
        System.out.println("Рекруты во французский легион:");
        personsRecruitment.forEach(System.out::println);
        return personsRecruitment;
    }

    public static List<Person> task13() {
        List<House> houses = Util.getHouses();
        List<Person> resultList = new ArrayList<>();
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
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .entrySet().stream()
                .filter(el -> !el.getKey())
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .forEach(resultList::add);

        List<Person> finallyResultList = resultList.stream()
                .limit(500)
                .toList();
        System.out.println("Люди попавшие в первые ряды эвакуировнных:");
        finallyResultList.forEach(System.out::println);
        return finallyResultList;
    }

    public static double task14() {
        List<Car> cars = Util.getCars();
        Map<String, List<Car>> echelonList = UtilForTask14.createEchelonList(cars);

        Double total = echelonList.entrySet().stream()
                .map(el -> {
                    long totalMass = UtilForTask14.getSumMass(el.getValue());
                    double transactionCost = totalMass / 1000.0 * 7.14;
                    double totalProfit = (double) UtilForTask14.getSumPrice(el.getValue()) - transactionCost;
                    UtilForTask14.outputResult(el.getKey(), totalMass, transactionCost, totalProfit);
                    return Map.entry(el.getKey(), totalProfit);
                })
                .map(Map.Entry::getValue)
                .reduce(0.0, Double::sum);
        System.out.printf("\nСуммарная выручка логистической компании: %.2f ($)", total);
        return total;
    }

    public static double task15() {
        List<Flower> flowers = Util.getFlowers();
        long countDaysOfFiveYears = 5 * 365 + 1;
        double totalPriceForServiceFlower = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin)
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay)
                        .reversed()
                )
                .filter(flower -> Pattern.matches("[C-S].+", flower.getCommonName()))
                .filter(flower -> flower.isShadePreferred() &&
                        flower.getFlowerVaseMaterial()
                                .stream()
                                .anyMatch(el ->
                                        Pattern.matches("Aluminum|Glass|Steel", el))
                )
                //далее учитывается, что расход воды дан в литрах
                .map(flower -> flower.getPrice() +
                        flower.getWaterConsumptionPerDay() * 1.39 / 1000 * countDaysOfFiveYears)
                .reduce(0.0, Double::sum);
        System.out.printf("Общая стоимость обслуживания растений (за 5 лет) = %.2f $", totalPriceForServiceFlower);
        return totalPriceForServiceFlower;
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
