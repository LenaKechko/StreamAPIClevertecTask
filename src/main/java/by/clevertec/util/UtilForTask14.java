package by.clevertec.util;

import by.clevertec.model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilForTask14 {
    public static long getSumMass(List<Car> carsList) {
        return carsList.stream()
                .reduce(0, (x, y) -> x + y.getMass(), Integer::sum);
    }

    public static long getSumPrice(List<Car> carsList) {
        return carsList.stream()
                .reduce(0, (x, y) -> x + y.getPrice(), Integer::sum);
    }

    public static void outputResult(String country, long totalMass, double transactionCost, double totalProfit) {
        System.out.println("---------- " + country + " ----------");
        System.out.println("Суммарная масса автомобилей (кг): " + totalMass);
        System.out.printf("Транспортные расходы: %.2f ($)\n", transactionCost);
        System.out.printf("Выручка: %.2f ($)\n", totalProfit);
    }

    public static Map<String, List<Car>> createEchelonList(List<Car> cars) {
        List<Car> temp = new ArrayList<>();
        Map<String, List<Car>> echelonList = new HashMap<>();
        if (!(temp = MyPredicate.filterCars(cars, MyPredicate.isFirstEchelon())).isEmpty()) {
            echelonList.put("Туркменистан", temp);
        }
        if (!(temp = MyPredicate.filterCars(cars, MyPredicate.isSecondEchelon()
                .and(MyPredicate.isFirstEchelon().negate())))
                .isEmpty()) {
            echelonList.put("Узбекистан", temp);
        }
        if (!(temp = MyPredicate.filterCars(cars, MyPredicate.isThirdEchelon()
                .and(MyPredicate.isFirstEchelon().negate())
                .and(MyPredicate.isSecondEchelon().negate()))).isEmpty()) {
            echelonList.put("Казахстан", temp);
        }
        if (!(temp = MyPredicate.filterCars(cars, MyPredicate.isFourthEchelon()
                .and(MyPredicate.isFirstEchelon().negate())
                .and(MyPredicate.isSecondEchelon().negate())
                .and(MyPredicate.isThirdEchelon().negate()))).isEmpty()) {
            echelonList.put("Кыргызстан", temp);
        }
        if (!(temp = MyPredicate.filterCars(cars, MyPredicate.isFifthEchelon()
                .and(MyPredicate.isFirstEchelon().negate())
                .and(MyPredicate.isSecondEchelon().negate())
                .and(MyPredicate.isThirdEchelon().negate())
                .and(MyPredicate.isFourthEchelon().negate()))).isEmpty()) {
            echelonList.put("Россия", temp);
        }
        if (!(temp = MyPredicate.filterCars(cars, MyPredicate.isSixthEchelon()
                .and(MyPredicate.isFirstEchelon().negate())
                .and(MyPredicate.isSecondEchelon().negate())
                .and(MyPredicate.isThirdEchelon().negate())
                .and(MyPredicate.isFourthEchelon().negate())
                .and(MyPredicate.isFifthEchelon().negate()))).isEmpty()) {
            echelonList.put("Монголия", temp);
        }
        return echelonList;
    }
}
