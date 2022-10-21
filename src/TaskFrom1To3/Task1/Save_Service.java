package TaskFrom1To3.Task1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Save_Service {
    private Storage storage;
    protected History history;

    public Storage getStorage() {
        return storage;
    }

    public History getHistory() {
        return history;
    }

    public void setStorage(final Storage storage) {
        this.storage = storage;
    }

    public Save_Service(final Storage storage, final History history) {
        this.storage = storage;
        this.history = history;
    }

    public void sellGood(final Map<Goods, Integer> goods, final Customer customer, final LocalDate date) {
        final Map<Goods, Integer> addGood = new HashMap<>();
        Check c = new Check(addGood, customer, date);

        for (Map.Entry<Goods, Integer> entry : goods.entrySet()) {
            storage.sellGoods(entry.getKey(), entry.getValue());
            c.addGood(entry.getKey(), entry.getValue());
        }

        history.addCheck(c);
    }

    public void receiveCargo(final Goods good, final int amount) {
        storage.addGoods(good, amount);
    }

    public void receiveCargo(final Map<Goods, Integer> deliveredGoods) {
        storage.addGoods(deliveredGoods);
    }

    @Override
    public String toString() {
        return "Save_Service{" +
                "storage=" + storage +
                ", history=" + history +
                '}';
    }
}
