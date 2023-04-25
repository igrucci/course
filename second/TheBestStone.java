public class TheBestStone extends DefoltStone {
    private String parametr3;

    public TheBestStone(String name, String parametr3, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
        this.parametr3 = parametr3;
    }

    public String getParametr3() {
        return parametr3;
    }

    public void setParametr3(String parametr3) {
        this.parametr3 = parametr3;
    }

    @Override
    public String toString() {
        return "name: " + getName() +  ", parametr3: " + getParametr3() + ", weight: " + getWeight() + ", price per carat: "+ getPrice_per_carat() + ", price: "+findprice() ;

    }
}
