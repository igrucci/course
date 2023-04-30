public class Precious extends DefoltStone {
    private String color;

    public Precious(String name, String color, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Название: " + getName() +  ", цвет: " + getColor() + ", вес: " + getWeight() + ", цена за карат: "+ getPrice_per_carat() + ", цена: "+findprice() ;

    }
}
