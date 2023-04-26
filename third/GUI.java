
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GUI extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private ArrayList<Student> students;

    public GUI() {

        setTitle("Студенты");
        setSize(600, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание таблицы
        String[] columns = {"Фамилия", "Номер группы", "Средний балл"};
        model = new DefaultTableModel(columns, 0);//изначально задано сколько. тк пусто то 0
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Создание панели с кнопками
        JPanel buttonPanel = new JPanel(new GridLayout(7, 1, 5, 5));
        getContentPane().add(buttonPanel, BorderLayout.EAST);

        JButton addButton = new JButton("Добавить");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //JOptionPane - диалоговое окно для взаимодействия
                String name = JOptionPane.showInputDialog("Введите фамилию");
                int groupNumber = Integer.parseInt(JOptionPane.showInputDialog("Введите номер группы студента"));
                int[] grades = new int[5];
                for (int i = 0; i < 5; i++) {
                    grades[i] = Integer.parseInt(JOptionPane.showInputDialog("Введите оценку " + (i+1)));
                }

                // Добавление студента
                addStudent(name, groupNumber, grades);
            }
        });
        buttonPanel.add(addButton);

        JButton searchButton = new JButton("Поиск");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Student> originalStudents = new ArrayList<>();
                String searchField = JOptionPane.showInputDialog("Введите поле для поиска (фамилия/группа):");
                String searchValue = JOptionPane.showInputDialog("Введите значение для поиска:");

                ArrayList<Student> filteredStudents = new ArrayList<Student>();

                // Отфильтровать
                for (Student student : students) {
                    if (searchField.equals("фамилия") && student.getName().contains(searchValue)) {
                        filteredStudents.add(student);
                    }
                    else if (searchField.equals("группа") && student.getGroup() == Integer.parseInt(searchValue)){
                        filteredStudents.add(student);
                    }
                }
                // Очистить таблицу
                    model.setRowCount(0);

                // Добавить отфильтрованных студентов в таблицу
                for (Student student : filteredStudents) {
                    Object[] row = {student.getName(), student.getGroup(), student.getAverageGrade()};
                    model.addRow(row);
                }
            }
        });

        buttonPanel.add(searchButton);

        JButton sortButton = new JButton("Сортировка");
        sortButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ArrayList<Student> originalStudents = new ArrayList<Student>(students);
                // Показать диалоговое окно с опциями сортировки
                String[] options = {"По группе", "По имени"};
                int selectedOption = JOptionPane.showOptionDialog(null, "Выберите критерий сортировки:", "Сортировка",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                // Сортировка данных по выбранному критерию
                if (selectedOption == 0) {
                    // Сортировка по группе
                    Collections.sort(students, new Comparator<Student>() {
                        public int compare(Student s1, Student s2) {
                            return s1.getGroup() - s2.getGroup();
                        }
                    });
                } else if (selectedOption == 1) {
                    // Сортировка по имени
                    Collections.sort(students, new Comparator<Student>() {
                        public int compare(Student s1, Student s2) {
                            return s1.getName().compareTo(s2.getName());
                        }
                    });
                }

                // Обновить данные в таблице
                model.setRowCount(0);//очистить
                for (Student student : students) {
                    Object[] row = {student.getName(), student.getGroup(), student.getAverageGrade()};
                    model.addRow(row);
                }
            }
        });
        buttonPanel.add(sortButton);

        JButton filterButton = new JButton("Фильтр");
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Вывод всех элементов, удовлетворяющих заданному условию
                filterStudents();
            }
        });
        buttonPanel.add(filterButton);

        // Добавить кнопку "Отменить"
        JButton cancelButton = new JButton("Показать всех");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Очистить таблицу
                model.setRowCount(0);
                ArrayList<Student> originalStudents = new ArrayList<Student>(students);
                // Отобразить исходный список студентов
                for (Student student : originalStudents) {
                    Object[] row = {student.getName(), student.getGroup(), student.getAverageGrade()};
                    model.addRow(row);
                }
            }
        });
        buttonPanel.add(cancelButton);

        JButton deleteButton = new JButton("Удалить");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Получение номера выбранной строки
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Удаление студента
                    deleteStudent(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Выберите строку для удаления");
                }
            }
        });
        buttonPanel.add(deleteButton);

        JButton saveButton = new JButton("Cохранить");
       saveButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // Получение выбранной строки
               int selectedRow = table.getSelectedRow();
               if (selectedRow != -1) {
                   // Получение данных строки
                   String name = (String) model.getValueAt(selectedRow, 0);
                   int group = (int) model.getValueAt(selectedRow, 1);
                   int averagegrade = (int) model.getValueAt(selectedRow, 3);

                   // Открытие диалога сохранения файла
               {
                       File fileToSave = new File("output.txt");
                       try {
                           // Сохранение данных в файл
                           FileWriter writer = new FileWriter(fileToSave);
                           writer.write(name + "," + group + "," + averagegrade);
                           writer.close();
                           JOptionPane.showMessageDialog(null, "Файл сохранен");
                       } catch (IOException ex) {
                           JOptionPane.showMessageDialog(null, "Ошибка при сохранении файла");
                       }
                   }
               }else {
                   JOptionPane.showMessageDialog(null, "Выберите строку для удаления");
           }
           }
       });
        buttonPanel.add(saveButton);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Создание меню "File"
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Создание пункта меню
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(saveItem);

        // Инициализация коллекции студентов
        students = new ArrayList<Student>();
    }

    public void addStudent(String name, int groupNumber, int[] grades) {
        // Создание объекта студента
        Student student = new Student(name, groupNumber, grades);

        // Добавление студента в коллекцию
        students.add(student);

        // Добавление данных студента в таблицу
        Object[] row = {student.getName(), student.getGroup(), student.getAverageGrade()};
        model.addRow(row);
    }
    public void deleteStudent(int row) {
        // Удаление студента из коллекции
        students.remove(row);

        // Удаление данных студента из таблицы
        model.removeRow(row);
    }

    public void filterStudents() {
        // Очистка таблицы
        model.setRowCount(0);

        // Поиск студентов со средним баллом выше 4.0
        for (Student student : students) {
            if (student.getAverageGrade() > 4.0) {
                // Добавление данных студента в таблицу
                Object[] row = {student.getName(), student.getGroup(), student.getAverageGrade()};
                model.addRow(row);
            }
        }
    }

    public static void main(String[] args) {
        GUI studentGUI = new GUI();
        studentGUI.setVisible(true);

    }
}

