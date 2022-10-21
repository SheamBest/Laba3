package TaskFrom1To3.Task1;

public class Customer {
    private String name;

    public Customer(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer client)) return false;

        return getName() != null ? getName().equals(client.getName()) : client.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
