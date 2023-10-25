package by.clevertec;

import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.util.Util;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

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
        expectedList = expectedList.subList(0,500);
        assertEquals(expectedList, Main.task13());

    }
}