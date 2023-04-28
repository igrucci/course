import java.util.Arrays;

class Student implements Comparable<Student> {
    private String name;
    private int group;
    private int[] grades;

    public Student(String name, int group, int[] grades){
        this.name = name;
        this.group = group;
        this.grades = grades;
    }

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

    public double getAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / 5;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + name + '\'' +
                ", group=" + group +
                ", grades=" + Arrays.toString(grades) +
                ", average grade = " + getAverageGrade() +
                '}';
    }
    @Override
    public int compareTo(Student other) {
        return Integer.compare(group, other.group);
    }

}
