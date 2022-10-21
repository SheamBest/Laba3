package TaskFrom1To3.Task1;

public class Goods {
    private String maker;
    private String name;
    private double buyingPrice;
    private double sellingPrice;

    public Goods(){

    }

    public Goods(final String maker, final String name, final double buyingPrice) {
        this.maker = maker;
        this.name = name;
        this.buyingPrice = buyingPrice;
    }

    public Goods(final String maker, final String name, final double buyingPrice, final double sellingPrice) {
        this.maker = maker;
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getMaker() {
        return maker;
    }

    public String getName() {
        return name;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }
}
