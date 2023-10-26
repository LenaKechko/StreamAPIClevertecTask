package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import by.clevertec.util.UtilForTask14;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import by.clevertec.model.Examination;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void task1() {
        List<Animal> animals = Util.getAnimals();
        int countAnimalsInZoo = 7;
        List<Animal> expectedList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() >= 10 && animal.getAge() <= 20) {
                expectedList.add(animal);
            }
        }
        expectedList.sort(Comparator.comparing(Animal::getAge));
        expectedList = expectedList.subList(2 * countAnimalsInZoo, 3 * countAnimalsInZoo);
        assertEquals(expectedList, Main.task1());
    }

    @Test
    void task2() {
        List<Animal> animals = Util.getAnimals();
        List<String> expectedList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getOrigin().equals("Japanese") && animal.getGender().equals("Female"))
                expectedList.add(animal.getBread().toUpperCase());
        }
        assertEquals(expectedList, Main.task2());
    }

    @Test
    void task3() {
        List<String> expectedList = List.of("Azeri", "Aymara", "Afrikaans",
                "Arabic", "Armenian", "Amharic", "Assamese", "Albanian");
        assertEquals(expectedList, Main.task3());
    }

    @Test
    void task4() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
        System.setOut(new PrintStream(outputStream));
        long exceptedResult = 0;
        List<Animal> animals = Util.getAnimals();
        for (Animal animal : animals) {
            if (animal.getGender().equals("Female")) exceptedResult++;
        }
        Main.task4();
        String exceptedResultConsole = String.format("Количество Female-животных: " + exceptedResult);
        assertEquals(exceptedResultConsole, outputStream.toString().trim());
    }

    @Test
    void task5() {
        List<Animal> animals = Util.getAnimals();
        List<Animal> expectedList = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() >= 20 && animal.getAge() <= 30
                    && animal.getOrigin().equals("Hungarian"))
                expectedList.add(animal);
        }
        assertEquals(expectedList, Main.task5());
    }

    @Test
    void task6() {
        List<Animal> animals = Util.getAnimals();
        boolean expectedResult = animals.stream()
                .map(Animal::getGender)
                .distinct()
                .allMatch(gender -> gender.equals("Male")
                        || gender.equals("Female"));
        assertEquals(expectedResult, Main.task6());

    }

    @Test
    void task7() {
        List<Animal> animals = Util.getAnimals();
        boolean expectedResult = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Oceania"))
                .findFirst()
                .isEmpty();
        assertEquals(expectedResult, Main.task7());
    }

    @Test
    void task8() {
        List<Animal> animals = Util.getAnimals();
        animals.sort(Comparator.comparing(Animal::getBread));
        animals = animals.subList(0, 100);
        animals.sort(Comparator.comparing(Animal::getAge));
        int expectedResult = animals.get(99).getAge();
        assertEquals(expectedResult, Main.task8());
    }

    @Test
    void task9() {
        List<Animal> animals = Util.getAnimals();
        int expectedResult = animals.stream()
                .map(Animal::getBread)
                .map(String::length)
                .min(Integer::compareTo)
                .orElseThrow();
        assertEquals(expectedResult, Main.task9());
    }


    @Test
    void task10() {
        List<Animal> animals = Util.getAnimals();
        long expectedResult = 0;
        for (Animal animal : animals) {
            expectedResult += animal.getAge();
        }
        assertEquals(expectedResult, Main.task10());
    }

    @Test
    void task11() {
        List<Animal> animals = Util.getAnimals();
        int countAnimals = 0;
        int sumAgeAnimals = 0;
        for (Animal animal : animals) {
            if (animal.getOrigin().equals("Indonesian")) {
                sumAgeAnimals += animal.getAge();
                countAnimals++;
            }
        }
        double exceptedResult = (double) sumAgeAnimals / countAnimals;
        assertEquals(exceptedResult, Main.task11());
    }

    @Test
    void task12() {
        List<Person> persons = Util.getPersons();
        List<Person> expectedResult = new ArrayList<>();
        for (Person person : persons) {
            int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
            if (person.getGender().equals("Male") &&
                    (age >= 18 && age <= 27)) {
                expectedResult.add(person);
            }
        }
        expectedResult.sort(Comparator.comparing(Person::getRecruitmentGroup));
        if (expectedResult.size() > 200)
            expectedResult = expectedResult.subList(0, 200);
        assertEquals(expectedResult, Main.task12());
    }

    @Test
    void task13() {
        List<House> houses = Util.getHouses();
        List<Person> expectedList = new ArrayList<>();
        for (House house : houses) {
            if (house.getBuildingType().equals("Hospital")) {
                expectedList.addAll(house.getPersonList());
            }
        }
        for (House house : houses) {
            boolean typeBuilding = house.getBuildingType().equals("Hospital");
            if (!typeBuilding) {
                for (Person person : house.getPersonList()) {
                    int personAge = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
                    if (personAge < 18 || personAge > 63)
                        expectedList.add(person);
                }
            }
        }
        for (House house : houses) {
            boolean typeBuilding = house.getBuildingType().equals("Hospital");
            if (!typeBuilding) {
                for (Person person : house.getPersonList()) {
                    int personAge = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
                    if (personAge >= 18 && personAge <= 63)
                        expectedList.add(person);
                }
            }
        }
        expectedList = expectedList.subList(0, 500);
        assertEquals(expectedList, Main.task13());

    }

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

    @Test
    void task16() {
        List<Student> students = Util.getStudents();
        List<Student> expectedResult = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() < 18)
                expectedResult.add(student);
        }
        expectedResult.sort(Comparator.comparing(Student::getSurname));
        assertEquals(expectedResult, Main.task16());
    }

    @Test
    void task17() {
        List<Student> students = Util.getStudents();
        List<String> expectedList = new ArrayList<>();
        for (Student student : students) {
            if (expectedList.contains(student.getGroup()))
                continue;
            expectedList.add(student.getGroup());
        }
        assertEquals(expectedList, Main.task17());
    }

    @Test
    void task18() {
        List<Student> students = Util.getStudents();
        Map<String, Double> expectedResult = new HashMap<>();
        Map<String, List<Integer>> temp = new HashMap<>();
        for (Student student : students) {
            String faculty = student.getFaculty();
<<<<<<<HEAD
            List<Integer> tempData = List.of(0, 0);
            if (temp.containsKey(faculty)) {
                tempData = temp.get(faculty);
            }
            int sumAge = tempData.get(0) + student.getAge();
            int countStudent = tempData.get(1) + 1;
            tempData = List.of(sumAge, countStudent);
            temp.put(faculty, tempData);
        }
        for (Map.Entry<String, List<Integer>> el : temp.entrySet()) {
            int sumAge = el.getValue().get(0);
            int countStudent = el.getValue().get(1);
            expectedResult.put(el.getKey(), (double) sumAge / countStudent);
        }
        expectedResult = expectedResult.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        assertEquals(expectedResult, Main.task18());
    }

    @Test
    void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        List<Student> expectedResult = new ArrayList<>();
        String group = "C-3";
        for (Student student : students) {
            if (student.getGroup().equals(group)) {
                for (Examination examination : examinations) {
                    if (student.getId() == examination.getStudentId() && examination.getExam3() > 4)
                        expectedResult.add(student);
                }
            }
        }
        assertEquals(expectedResult, Main.task19());
    }

    @Test
    void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<String, Double> expectedResult = new HashMap<>();
        Map<String, List<Integer>> temp = new HashMap<>();
        for (Student student : students) {
            String faculty = student.getFaculty();
            List<Integer> aboutMarks = List.of(0, 0);
            if (temp.containsKey(faculty)) {
                aboutMarks = temp.get(faculty);
            }
            for (Examination examination : examinations) {
                if (examination.getStudentId() == student.getId()) {
                    aboutMarks = List.of(aboutMarks.get(0) + examination.getExam1(),
                            aboutMarks.get(1) + 1);
                }
            }
            temp.put(faculty, aboutMarks);
        }
        Map<String, Double> finalExpectedResult = new HashMap<>();

        temp.forEach((faculty, value) -> {
            double averageMark = (double) value.get(0) / value.get(1);
            expectedResult.put(faculty, averageMark);
        });
        finalExpectedResult = expectedResult.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        assertEquals(finalExpectedResult, Main.task20());
    }
}