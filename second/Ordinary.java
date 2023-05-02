// Этот класс является наследником абстрактного класса DefoltStone, и представляет обычные камни.
// Он содержит дополнительное поле hardness (твердость) и реализует метод toString(), чтобы предоставить информацию о камне.
// Он также использует конструктор родительского класса для инициализации общих свойств камней.
public class Ordinary extends DefoltStone {
    private String hardness;

    // Конструктор для создания экземпляра класса Ordinary с заданными значениями полей
    public Ordinary(String name, String hardness, double weight, double price_per_carat) {
        super(name, weight, price_per_carat); // вызываем конструктор родительского класса
        this.hardness = hardness;
    }

    // Геттеры и сеттеры для поля hardness
    public String getHardness() {
        return hardness;
    }
    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    // Переопределение метода toString() для предоставления информации о камне
    @Override
    public String toString() {
        return "Название: " + getName() +  ", твердость: " + getHardness() + ", вес: " + getWeight() + ", цена за карат: "+ getPrice_per_carat() + ", цена: "+findprice() ;
    }
}