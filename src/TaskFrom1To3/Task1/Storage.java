package TaskFrom1To3.Task1;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Goods, Integer> goods;

    public Storage(final Map<Goods, Integer> goods) {
        this.goods = goods;
    }

    public Map<Goods, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<Goods, Integer> goods) {
        this.goods = goods;
    }

    public void addGoods(final Goods good, final int amount) {
        if (goods == null) {
            goods = new HashMap<>();
        }

        for (Map.Entry<Goods, Integer> entry : goods.entrySet()) {
            if (entry.getKey().equals(good.getName()) && entry.getKey().
                    getMaker().equals(good.getMaker()) && entry.getKey().
                    getBuyingPrice() == good.getBuyingPrice()) {
                final  int result = entry.getValue() + amount;
                entry.setValue(result);
                return;
            }
        }

        final Goods addGood = new Goods(good.getMaker(), good.getName(),
                good.getBuyingPrice(), good.getSellingPrice());
        this.goods.put(addGood, amount);
    }

    public void addGoods(final Map<Goods, Integer> deliveredGoods) {
        if (goods == null) {
            goods = new HashMap<>();
        }

        for (Map.Entry<Goods, Integer> deliveredEntry : deliveredGoods.entrySet()) {
            boolean available = false;

            for (Map.Entry<Goods, Integer> availableEntry : goods.entrySet()) {
                if (availableEntry.getKey().getName().equals(deliveredEntry.getKey().
                        getName()) && availableEntry.getKey().getMaker().
                        equals(deliveredEntry.getKey().getMaker()) && availableEntry.
                        getKey().getBuyingPrice() == deliveredEntry.getKey().getBuyingPrice()) {
                    available = true;
                    final  int result = availableEntry.getValue() + deliveredEntry.getValue();
                    availableEntry.setValue(result);
                }
            }

            if (!available) {
                final  Goods addGood = new Goods(deliveredEntry.getKey().getMaker(),
                        deliveredEntry.getKey().getName(), deliveredEntry.getKey().getBuyingPrice(),
                        deliveredEntry.getKey().getSellingPrice());
                this.goods.put(addGood, deliveredEntry.getValue());
            }
        }
    }

    public void sellGoods(final Goods good, int amount) {
        for (Map.Entry<Goods, Integer> entry : goods.entrySet()) {
            if (entry.getKey().getName().equals(good.getName()) && entry.getKey().
                    getMaker().equals(good.getMaker())) {
                if (entry.getValue() == amount) {
                    goods.remove(entry);
                } else if (entry.getValue() > amount) {
                    final  int result = entry.getValue() - amount;
                    entry.setValue(result);
                    return;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Storage{" +
                "goods=" + goods +
                '}';
    }
}
