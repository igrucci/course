// Этот класс является наследником абстрактного класса PreciousStone, и представляет драгоценные камни.
// Он содержит дополнительное поле transparency (прозрачность) и реализует метод toString(), чтобы предоставить информацию о камне.
// Он также использует конструктор родительского класса для инициализации общих свойств камней
public class Precious extends DefoltStone {
    private String color;

    // Конструктор для создания экземпляра класса SemiPrecious с заданными значениями полей
    public Precious(String name, String color, double weight, double price_per_carat) {
        super(name, weight, price_per_carat);
        this.color = color;
    }

    // Геттеры и сеттеры для поля transparency
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Переопределение метода toString() для предоставления информации о камне
    @Override
    public String toString() {
        return "Название: " + getName() +  ", цвет: " + getColor() + ", вес: " + getWeight() + ", цена за карат: "+ getPrice_per_carat() + ", цена: "+findprice() ;

    }
}
