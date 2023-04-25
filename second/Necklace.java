public class Necklace extends DefoltStone {
private double total_weight;
private double total_price;



    public Necklace(String name, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
    }

    public double GetTotalPrice() {
        return findprice();
    }
}
