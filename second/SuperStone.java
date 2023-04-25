public class SuperStone extends DefoltStone {
    private String parametr1;


    public SuperStone(String name, String parametr1, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
       this.parametr1 = parametr1;
    }

    public String getParametr1() {
        return parametr1;
    }
    public void setParametr1(String parametr1) {
        this.parametr1 = parametr1;
    }

    @Override
    public String toString() {
        return "name: " + getName() +  ", parametr1: " + getParametr1() + ", weight: " + getWeight() + ", price per carat: "+ getPrice_per_carat() + ", price: "+findprice() ;

    }
}
