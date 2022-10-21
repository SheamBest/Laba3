package TaskFrom1To3;

import TaskFrom1To3.Task1.*;
import TaskFrom1To3.Task2.Cargo_Department;
import TaskFrom1To3.Task2.Exceptions.*;
import TaskFrom1To3.Task3.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TaskFrom1To3 {
    public static void main(String[] args) {
        final Customer customer1 = new Customer("Maksym");
        final Customer customer2 = new Customer("Dave");

        final Goods milk_product1 = new Goods("Yagotynske",
                "Milk, 1l", 28, 35);
        Map<Goods, Integer> goods = new HashMap<>();
        goods.put(milk_product1, 3);
        final Goods milk_product2 = new Goods("Yagotynske", "Yogurt",
                32, 45);
        final Goods bread = new Goods("Monastyrs'kyi", "Bread",
                16, 20);
        final Goods rice  = new Goods("Kukharochka", "Rice boiled",
                40, 64);
        final Goods chocolate = new Goods("Roshen", "Chocolate bar",
                30, 65);
        LinkedList<Check> history = new LinkedList<>();

        Save_Service rukavychka = new Save_Service(new Storage(goods), new History(history));
        Cargo_Department rukavychkaCargo = new Cargo_Department(rukavychka);
        rukavychkaCargo.receiveCargo(milk_product1, 300);
        rukavychkaCargo.receiveCargo(milk_product2, 500);
        rukavychkaCargo.receiveCargo(bread, 500);
        rukavychkaCargo.receiveCargo(rice, 2000);
        rukavychkaCargo.receiveCargo(chocolate, 80);

        try {
            if (rukavychkaCargo.validate(rukavychkaCargo.getReport())) {
                System.out.print("Check was done successfully");
            }
        } catch (final NoMakerException | NoNameException | WrongBuyingPriceException |
                       WrongSellingPriceException | WrongAmountException err)
        {
            throw new RuntimeException(err);
        }

        Map<Goods, Integer> purchase1 = new HashMap<>();
        purchase1.put(milk_product1, 2);
        purchase1.put(bread, 1);
        purchase1.put(chocolate, 2);

        Map<Goods, Integer> purchase2 = new HashMap<>();
        purchase2.put(rice, 1);
        purchase2.put(bread, 1);

        Map<Goods, Integer> purchase3 = new HashMap<>();
        purchase3.put(milk_product2, 10);
        purchase3.put(chocolate, 4);

        rukavychka.sellGood(purchase1, customer1, LocalDate.of(2022, 11, 8));
        rukavychka.sellGood(purchase2, customer2, LocalDate.of(2022, 11, 9));
        rukavychka.sellGood(purchase3, customer1, LocalDate.of(2022, 11, 10));

        Service service = new Service(rukavychka);
        service.sortGoodsByAlphabet();

        System.out.print("\n Purchased by Maksym: \n");
        service.getAllGoodsByClient(customer1);

        System.out.print("\n Purchased by Dave: \n");
        service.getAllGoodsByClient(customer2);

        System.out.print("The biggest income:");
        service.getBiggestIncome();
        System.out.print("\n");

        System.out.print("\n The most popular good:");
        service.getMostPopularGood();
        System.out.print("\n");
    }
}
