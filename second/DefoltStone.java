// Класс, представляющий общую абстрактную реализацию камня.
public abstract class DefoltStone {
    // Поля класса, определяющие имя камня, его вес и цену за карат.
    private String name;
    private double weight;
    private double price_per_carat;

    // Конструктор класса, инициализирующий поля объекта.
    public DefoltStone(String name, double weight, double price_per_carat) {
        this.name = name;
        this.price_per_carat = price_per_carat;
        this.weight = weight;
    }

    // Методы получения и установки имени камня.
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Методы получения и установки веса камня.
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Методы получения и установки цены за карат.
    public double getPrice_per_carat() {
        return price_per_carat;
    }
    public void setPrice_per_carat(double price_per_carat) {
        this.price_per_carat = price_per_carat;
    }

    // Метод, вычисляющий стоимость камня.
    public double findprice() {
        return weight * price_per_carat;
    }
}