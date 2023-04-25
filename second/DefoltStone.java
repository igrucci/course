public abstract class DefoltStone {
    private String name;
    private double weight;
    private double price_per_carat;

    public DefoltStone(String name, double weight, double price_per_carat) {
        this.name = name;
        this.price_per_carat = price_per_carat;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getPrice_per_carat() {
        return price_per_carat;
    }
    public void setPrice_per_carat(double price_per_carat) {
        this.price_per_carat = price_per_carat;
    }
    public double findprice() {
        return weight * price_per_carat;
    }
}
