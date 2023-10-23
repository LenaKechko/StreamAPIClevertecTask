package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
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
        List<Examination> examinations = Util.getExaminations();

//для задания 19!!!
//        students.stream()
//                .collect(Collectors.toMap(Function.identity(),
//                        student -> examinations.stream()
//                                .filter(examination ->
//                                        examination.getStudentId() == student.getId())
//                                .map(Examination::getExam1)
//                                .findFirst().orElse(0)
//                ))
//                .entrySet().stream()
//                .forEach(System.out::println);

        students.stream()
                .collect(Collectors.toMap(Function.identity(),
                        student -> examinations.stream()
                                .filter(examination ->
                                        examination.getStudentId() == student.getId())
                                .map(Examination::getExam1)
                                .findFirst()

                ))
                .entrySet().stream()
                .collect(Collectors.groupingBy(el -> el.getKey().getFaculty(),
                        Collectors.averagingDouble(el -> el.getValue().isPresent())))
                .entrySet().stream()
                .forEach(System.out::println);

//        students.stream()
//                .collect(Collectors.groupingBy(
//                        Student::getFaculty,
//                        Collectors.toMap(Student::getId,
//                                student -> examinations.stream()
//                                        .filter(examination ->
//                                                examination.getStudentId() == student.getId())
//                                        .map(Examination::getExam1)
//                                        .findFirst().orElse(0)
//                        )))
//                .entrySet().stream()
//
//                .forEach(System.out::println);

//        students.stream()
//                .collect(Collectors.toMap(Function.identity(),
//                        student -> examinations.stream()
//                                .filter(examination ->
//                                        examination.getStudentId() == student.getId())
//                                .collect(Collectors.toList())
//                ))
//                .entrySet().stream()
//                .collect(Collectors.groupingBy(
////                        Student::getFaculty,
////                        Collectors.mapping(Student::getId, Collectors.toList())
////                ));
//                .forEach(System.out::println);


//        bookingRepository.findAll()
//                .stream()
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        booking -> booking.getProducts().stream()
//                                .mapToDouble(Product::getPrice).sum()
//                ));

//                .map(student -> examinations.stream()
//                        .filter(examination ->
//                                examination.getStudentId() == student.getId())
//                        .findFirst().get()
//                )
        ;
//                .filter(Objects::nonNull)
//                .toList();
//        studentsPassingThirdExam.forEach(System.out::println);
//        return studentsPassingThirdExam;
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
