public class SemiPrecious extends DefoltStone {
    private String transparency;

    public SemiPrecious(String name, String parametr2, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
        this.transparency = parametr2;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    @Override
    public String toString() {
        return "Название: " + getName() +  ", прозрачность: " + getTransparency() + ", вес: " + getWeight() + ", цена за карат: "+ getPrice_per_carat() + ", цена: "+findprice() ;

    }
}

