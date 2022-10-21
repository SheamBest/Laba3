package TaskFrom1To3.Task1;

import java.util.LinkedList;

public class History {
    private LinkedList<Check> checks;

    public History(final LinkedList<Check> checks) {
        this.checks = checks;
    }

    public void addCheck(final Check check) {
        this.checks.add(check);
    }

    public LinkedList<Check> getChecks() {
        return checks;
    }

    @Override
    public String toString() {
        return "History{" +
                "receipts=" + checks +
                '}';
    }
}
