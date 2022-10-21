package TaskFrom1To3.Task1;

import java.time.LocalDate;
import java.util.Map;

public class Check {
    private Map<Goods, Integer> goods;
    private Customer customer;

    private LocalDate date;

    public Check(final Map<Goods, Integer> goods, final Customer customer, final LocalDate date) {
        this.goods = goods;
        this.customer = customer;
        this.date = date;
    }

    public Check(final Customer customer, final LocalDate date) {
        this.customer = customer;
        this.date = date;
    }

    public Check(final Map<Goods, Integer> goods, final Customer customer) {
        this.goods = goods;
        this.customer = customer;
    }

    public Check(final Customer customer) {
        this.customer = customer;
    }


    public Check() {
    }

    public LocalDate getDate() {
        return date;
    }


    public Map<Goods, Integer> getGoods() {
        return goods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addGood(final Goods goods, final int amount) {
        final Goods addGood = new Goods(goods.getMaker(), goods.getName(), goods.getBuyingPrice(), goods.getSellingPrice());
        this.goods.put(addGood, amount);
    }

    public void addGood(final Map<Goods, Integer> goods) {
        for (Map.Entry<Goods, Integer> entry : goods.entrySet()) {
            final Goods addGood = new Goods(entry.getKey().getMaker(), entry.getKey().getName(), entry.getKey().getBuyingPrice(), entry.getKey().getSellingPrice());
            this.goods.put(addGood, entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Check{" +
                "goods = " + goods +
                ", customer = " + customer +
                ", date = " + date +
                '}';
    }
}
