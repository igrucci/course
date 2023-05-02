// Объявление класса "Студент", реализующего интерфейс "Comparable"
class Student implements Comparable<Student> {

    // Объявление приватных полей класса
    private String name; // Имя студента
    private int group; // Номер группы
    private int[] grades; // Оценки студента

    // Конструктор класса, инициализирующий поля класса
    public Student(String name, int group, int[] grades){
        this.name = name;
        this.group = group;
        this.grades = grades;
    }

    // Геттеры и сеттеры для полей класса
    public String getName() {
        return name;
    }

    public void setName(String surname) {
        this.name = surname;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    // Метод для расчета средней оценки студента
    public double getAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / 5;
    }

    // Реализация метода интерфейса "Comparable"
    // Данный метод сравнивает студентов по номеру группы
    @Override
    public int compareTo(Student other) {
        return Integer.compare(group, other.group);
    }

}