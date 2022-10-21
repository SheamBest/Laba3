package TaskFrom1To3.Task2;

import TaskFrom1To3.Task1.Goods;
import TaskFrom1To3.Task1.Save_Service;
import TaskFrom1To3.Task2.Exceptions.*;

import java.util.Map;

public class Cargo_Department {
    private Save_Service save;

    public Cargo_Department(final Save_Service save) {
        this.save = save;
    }

    public Map<Goods, Integer> getReport() {
        return save.getStorage().getGoods();
    }

    public void receiveCargo(final Goods good, final int amount) {
        save.receiveCargo(good, amount);
    }

    public void receiveCargo(final Map<Goods, Integer> deliveredGoods) {
        save.receiveCargo(deliveredGoods);
    }
    public boolean validate(final Map<Goods, Integer> report) throws
            NoMakerException, NoNameException, WrongBuyingPriceException,
            WrongSellingPriceException, WrongAmountException {
        for (Map.Entry<Goods, Integer> entry : report.entrySet()) {
            if (entry.getKey().getMaker().isEmpty()) {
                throw new NoMakerException();
            }
            else if (entry.getKey().getName().isEmpty()) {
                throw new NoNameException();
            }
            else if (entry.getValue() < 0) {
                throw new WrongAmountException();
            }
            else if (entry.getKey().getBuyingPrice() <= 0) {
                throw new WrongBuyingPriceException();
            }
            else if (entry.getKey().getSellingPrice() <= 0) {
                throw new WrongSellingPriceException();
            }
        }

        return true;
    }
}
