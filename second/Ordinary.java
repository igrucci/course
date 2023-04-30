public class Ordinary extends DefoltStone {
    private String hardness;


    public Ordinary(String name, String hardness, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
        this.hardness = hardness;
    }

    public String getHardness() {
        return hardness;
    }
    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    @Override
    public String toString() {
        return "Название: " + getName() +  ", твердость: " + getHardness() + ", вес: " + getWeight() + ", цена за карат: "+ getPrice_per_carat() + ", цена: "+findprice() ;

    }
}
