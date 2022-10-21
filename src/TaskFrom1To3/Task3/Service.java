package TaskFrom1To3.Task3;

import TaskFrom1To3.Task1.*;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Service {
    private Save_Service save;

    public Service(Save_Service save) {
        this.save = save;
    }

    public void sortGoodsByAlphabet() {
        Map<Goods, Integer> sortedGoods = save.getStorage().getGoods().entrySet().stream().sorted((e1, e2) -> {
            String firstCompareValue = e1.getKey().getName();
            String secondCompareValue = e2.getKey().getName();
            int compared = firstCompareValue.compareToIgnoreCase(secondCompareValue);
            return Integer.compare(compared, 0);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        save.getStorage().setGoods(sortedGoods);
    }

    public void sortGoodsByPrice() {
        Map<Goods, Integer> sortedGoods = save.getStorage().getGoods().entrySet().stream().sorted((e1, e2) -> {
            double firstCompareValue = e1.getKey().getSellingPrice();
            double secondCompareValue = e2.getKey().getSellingPrice();
            return Double.compare(secondCompareValue, firstCompareValue);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        save.getStorage().setGoods(sortedGoods);
    }

    public double getAveragePrice() {
        return save.getStorage().getGoods().keySet().
                stream().mapToDouble(Goods::getSellingPrice).average().orElse(Double.NaN);
    }

    public double getTotalSpendByClient(final Customer customer, final LocalDate from, final LocalDate to) {
        AtomicReference<Double> result = new AtomicReference<>((double) 0);
        save.getHistory().getChecks().forEach((receipt) -> {
            if (receipt.getCustomer().equals(customer) && (receipt.getDate().
                    isEqual(from) || receipt.getDate().isAfter(from)) && (receipt.getDate().
                    isEqual(to) || receipt.getDate().isBefore(to)))
            {
                receipt.getGoods().forEach((key, value) -> result.updateAndGet(v -> (double) (v + key.getSellingPrice() * value)));
            }
            ;
        });

        return result.get();
    }
    public void filterGoodsByMinAndMax(final double min, final double max) {
        Map<Goods, Integer> sortedGoods = save.getStorage().getGoods().entrySet().
                stream().filter(e -> e.getKey().getSellingPrice() >= min && e.getKey().
                        getSellingPrice() <= max).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        save.getStorage().setGoods(sortedGoods);
    }

    public void getAllGoodsByClient(final Customer customer) {
        LinkedList<Check> receipts = save.getHistory().getChecks();
        LinkedList<Check> filteredReceipts = receipts.stream().filter(e -> e.getCustomer().
                equals(customer)).collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Goods> allGoods = new LinkedList<Goods>();

        for (Check c : filteredReceipts) {
            for (Map.Entry<Goods, Integer> g : c.getGoods().entrySet()) {
                for (int i = 0; i < g.getValue(); i++) {
                    allGoods.push(g.getKey());
                }
            }
        }

        Map<String, Long> resultCount = allGoods.
                stream().collect(Collectors.groupingBy(Good -> "Name: " +
                        Good.getName() + "; Maker: " +
                        Good.getMaker(), Collectors.counting()));

        for (Map.Entry<String, Long> entry : resultCount.entrySet()) {
            System.out.println(entry.getKey() + "; Count: " + entry.getValue().toString() + ";");
        }
    }

    public void getBiggestIncome() {
        LinkedList<Check> receipts = save.getHistory().getChecks();

        Map<LocalDate, Double> entryCalculateReceipt = receipts.
                stream().collect(Collectors.toMap(Check::getDate, p -> {
                    AtomicReference<Double> res = new AtomicReference<>((double) 0);
                    p.getGoods().forEach((key, value) -> res.set((key.
                            getSellingPrice() - key.getBuyingPrice()) * value));
                    return res.get();
                }, (v1, v2) -> v1, LinkedHashMap::new));


        Map<LocalDate, Double> entryCalculatedByDate = entryCalculateReceipt.entrySet().stream()
                .collect(groupingBy(Map.Entry::getKey, summingDouble(Map.Entry::getValue)));

        Map<LocalDate, Double> sortedDates = entryCalculatedByDate.entrySet().
                stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        System.out.printf("\n" + sortedDates.entrySet().stream().reduce((one, two) -> two).
                get().getKey() + "; Total income: " + Math.round(sortedDates.entrySet().
                stream().reduce((one, two) -> two).get().getValue() * 100.0) / 100.0 + "\n");

    }
    public void getMostPopularGood() {
        LinkedList<Check> receipts = save.getHistory().getChecks();
        LinkedList<Goods> allGoods = new LinkedList<Goods>();

        for (Check c : receipts) {
            for (Map.Entry<Goods, Integer> g : c.getGoods().entrySet()) {
                for (int i = 0; i < g.getValue(); i++) {
                    allGoods.push(g.getKey());
                }
            }
        }

        Map<String, Long> resultCount = allGoods.stream().collect(groupingBy(Good ->
                "Name: " + Good.getName() + "; Maker: " + Good.getMaker(), Collectors.counting()));

        Map<String, Long> sortedGoods = resultCount.entrySet().stream().
                sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        System.out.printf("\n" + sortedGoods.entrySet().stream().
                reduce((one, two) -> two).get().getKey() + "; Count: " + sortedGoods.
                entrySet().stream().reduce((one, two) -> two).get().getValue() + "\n");
    }


}
