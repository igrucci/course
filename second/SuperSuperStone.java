public class SuperSuperStone extends DefoltStone {
    private String parametr2;

    public SuperSuperStone(String name, String parametr2, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
        this.parametr2 = parametr2;
    }

    public String getParametr2() {
        return parametr2;
    }

    public void setParametr2(String parametr2) {
        this.parametr2 = parametr2;
    }

    @Override
    public String toString() {
        return "name: " + getName() +  ", parametr2: " + getParametr2() + ", weight: " + getWeight() + ", price per carat: "+ getPrice_per_carat() + ", price: "+findprice() ;

    }
}

