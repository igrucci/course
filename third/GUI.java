import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        getContentPane().add(buttonPanel, BorderLayout.EAST);

        JButton addButton = new JButton("Добавить");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Введите фамилию");
                int groupNumber = 0;
                while (true) {
                    try {
                        groupNumber = Integer.parseInt(JOptionPane.showInputDialog("Введите номер группы"));
                        break;
                    } catch (NumberFormatException ex) {

                        JOptionPane.showMessageDialog(null, "Введите число");
                    }
                }

                int[] grades = new int[5];
                for (int i = 0; i < 5; i++) {
                    while (true) {
                        try {
                            int grade = Integer.parseInt(JOptionPane.showInputDialog("Введите оценку " + (i + 1)));
                            if (grade > 10 || grade < 0) {
                                JOptionPane.showMessageDialog(null, "Оценка должна быть от 0 и до 10");
                            } else {
                                grades[i] = grade;
                                break; // выйти из цикла если ввод корректный
                            }
                        } catch (NumberFormatException ex) {
                            // обработка исключения, если введенная строка не может быть преобразована в число
                            JOptionPane.showMessageDialog(null, "Введите число");
                        }
                    }
                }

                addStudent(name, groupNumber, grades);
            }
        });
        buttonPanel.add(addButton);

        JButton searchButton = new JButton("Поиск");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Student> originalStudents = new ArrayList<>();

                // Показать диалоговое окно с опциями сортировки
                String[] options = {"фамилия", "грпуппа"};
                int selectedOption = JOptionPane.showOptionDialog(null, "Выберите критерий поиска:", "Поиска",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                ArrayList<Student> filteredStudents = new ArrayList<Student>();
                String searchValue  = JOptionPane.showInputDialog("Введите");
                // Сортировка данных по выбранному критерию
                for (Student student : students) {
                    if (selectedOption == 0) {
                        // Сортировка по группе
                        if (student.getName().contains(searchValue)) {
                            filteredStudents.add(student);
                        }
                    }

                    else if (selectedOption == 1) {
                        // Сортировка по имени
                        if (student.getGroup() == Integer.parseInt(searchValue)) {
                            filteredStudents.add(student);

                        }
                    }
                }

                model.setRowCount(0);

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
                String[] options = {"По группе", "По фамилии"};
                int selectedOption = JOptionPane.showOptionDialog(null, "Выберите критерий сортировки:", "Сортировка",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

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

                model.setRowCount(0);

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

                filterStudents();
            }
        });
        buttonPanel.add(filterButton);

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

                    deleteStudent(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Выберите строку для удаления");
                }
            }
        });
        buttonPanel.add(deleteButton);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Создание меню
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);


        JMenuItem saveItem = new JMenuItem("Сохранить в файл");
        fileMenu.add(saveItem);

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Выбор файла для сохранения
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Получение выбранного файла
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(selectedFile);

                        for (Student student : students) {
                            writer.write(student.getName() + "\t" + student.getGroup() + "\t");
                            int[] grades = student.getGrades();
                            for (int i = 0; i < grades.length; i++) {
                                writer.write(grades[i] + " ");
                            }
                            writer.write("\n");
                        }
                        writer.close();
                        JOptionPane.showMessageDialog(null, "Готово");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Ошибка");
                    }
                }
            }
        });

        JMenuItem readItem = new JMenuItem("Прочесть с файла");
        fileMenu.add(readItem);
        readItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    int result = fileChooser.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                String[] fields = line.split(" ");
                                String name = fields[0];
                                int group = Integer.parseInt(fields[1]);
                                int[] grades = new int[5];
                                for (int i = 0; i < 5; i++) {
                                    grades[i] = Integer.parseInt(fields[2 + i]);
                                }
                            //    double averageGrade = getAverageGrade();
                                Student student = new Student(name, group, grades);
                                students.add(student);
                                model.addRow(new Object[]{
                                        name,
                                        group,
                                        student.getAverageGrade()
                                });
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });

        // Инициализация коллекции студентов
        students = new ArrayList<Student>();
    }

    public void addStudent(String name, int groupNumber, int[] grades) {

        Student student = new Student(name, groupNumber, grades);

        // Добавление в коллекцию
        students.add(student);

        // Добавление  в таблицу
        Object[] row = {student.getName(), student.getGroup(), student.getAverageGrade()};
        model.addRow(row);
    }
    public void deleteStudent(int row) {
        // из коллекции
        students.remove(row);

        // из таблицы
        model.removeRow(row);
    }

    public void filterStudents() {
        model.setRowCount(0);

        // Поиск студентов со средним баллом выше 4.0
        for (Student student : students) {
            if (student.getAverageGrade() > 4.0) {
                Object[] row = {student.getName(), student.getGroup(), student.getAverageGrade()};
                model.addRow(row);
            }
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   //     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        GUI studentGUI = new GUI();
        studentGUI.setVisible(true);

    }
}

