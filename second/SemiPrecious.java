// Этот класс является наследником абстрактного класса DefoltStone, и представляет драгоценные камни.
// Он содержит дополнительное поле transparency (прозрачность) и реализует метод toString(), чтобы предоставить информацию о камне.
// Он также использует конструктор родительского класса для инициализации общих свойств камней.
public class SemiPrecious extends DefoltStone {
    private String transparency;

    // Конструктор для создания экземпляра класса SemiPrecious с заданными значениями полей
    public SemiPrecious(String name, String transparency, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
        this.transparency = transparency;
    }

    // Геттеры и сеттеры для поля transparency
    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    // Переопределение метода toString() для предоставления информации о камне
    @Override
    public String toString() {
        return "Название: " + getName() +  ", прозрачность: " + getTransparency() + ", вес: " + getWeight() + ", цена за карат: "+ getPrice_per_carat() + ", цена: "+findprice() ;

    }
}

