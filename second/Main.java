import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество обычных камней");
        int n = scanner.nextInt();

        // создаем массив объектов Ordinary
        Ordinary[] spstones = new Ordinary[n];
        for (int i = 0; i < n; i++) {
            System.out.println("==============================================================");

            // вводим название камня
            System.out.print("Введите названия камня " + i + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String name = scanner.next();

            // вводим вес камня
            System.out.print("Введите вес камня " + i + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();

            // вводим твердость камня
            System.out.print("Введите твердость " + i + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String hardness = scanner.next();

            // вводим цену за карат камня
            System.out.print("Введите цену за карат " + i + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();

            // создаем объект Ordinary и добавляем его в массив
            spstones[i] = new Ordinary(name, hardness, weight, price_per_carat);
        }

        System.out.println("==============================================================");

        // вводим количество полудрагоценных камней
        Scanner scannerspsp = new Scanner(System.in);
        System.out.println("Введите количество полудрагоценных");
        int m = scannerspsp.nextInt();

        // создаем массив объектов SemiPrecious
        SemiPrecious[] spspstones = new SemiPrecious[m];
        for (int k = 0; k < m; k++) {
            System.out.println("==============================================================");

            // вводим название камня
            System.out.print("Введите название " + k + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String name = scanner.next();

            // вводим вес камня
            System.out.print("Введите вес " + k + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();

            // вводим прозрачность камня
            System.out.print("Введите прозрачность " + k + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String transparency = scanner.next();

            // вводим цену за карат камня
            System.out.print("Введите цену за карат " + k + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();
            // создаем объект SemiPrecious и добавляем его в массив
            spspstones[k] = new SemiPrecious(name, transparency, weight, price_per_carat);

        }

        System.out.println("==============================================================");

        // вводим количество драгоценных камней
        Scanner scannertb = new Scanner(System.in);
        System.out.println("Введите количество драгоценных");
        int p = scannertb.nextInt();


        Precious[] tbstones = new Precious[p];
        for (int j = 0; j < p; j++) {
            System.out.println("==============================================================");
            // вводим название камня
            System.out.print("Введите название " + j + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String name = scanner.next();
            // вводим вес камня
            System.out.print("Введите вес " + j + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();

            // вводим цвет камня
            System.out.print("Введите цвет" + j + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String color = scanner.next();

            // вводим цену за карат камня
            System.out.print("Введите цену за карат " + j + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();

            tbstones[j] = new Precious(name, color, weight, price_per_carat);
        }

        System.out.println("==============================================================");


        // Вывод информации
        System.out.println("Обычные камни:");
        for (Ordinary stone : spstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("Полудрагоценные камни:");
        for (SemiPrecious stone : spspstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("Драгоценные камни:");
        for (Precious stone : tbstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }


        double totalWeight = 0;
        double totalPrice = 0;
        StringBuilder allnames = new StringBuilder();
        Scanner scanforchoice = new Scanner(System.in);

        int choice;
        // меню для выбора камня в ожерелье
        do {
            System.out.println("Меню:");
            System.out.println("1. обычные");
            System.out.println("2. полудрагоценные");
            System.out.println("3. драгоценные");
            System.out.println("0. ожерелье");

            System.out.print("Выберите: ");
            choice =scanforchoice.nextInt();

            switch (choice) {
                case 1 -> {
                    Scanner scansp = new Scanner(System.in);
                    System.out.print("Введите название(обычные): ");
                    String NameForNecklace1 = scansp.nextLine();
                    boolean isFind = false;
                    for (Ordinary stone : spstones) {

                        if (stone.getName().equals(NameForNecklace1)) {
                            System.out.println(stone);
                            totalWeight += stone.getWeight();
                            totalPrice += stone.getPrice_per_carat() * stone.getWeight();
                            allnames.append(stone.getName()).append(" ");
                            isFind = true;
                            break;
                        }
                    }
                    if(!isFind){
                        System.out.println("не найден");
                    }
                }
                case 2 -> {
                    Scanner scanspsp = new Scanner(System.in);
                    System.out.print("Введите название(полудрагоценные): ");
                    String NameForNecklace2 = scanspsp.nextLine();
                    boolean isFind = false;
                    for (SemiPrecious stone : spspstones) {

                        if (stone.getName().equals(NameForNecklace2)) {
                            System.out.println(stone);
                            totalWeight += stone.getWeight();
                            totalPrice += stone.getPrice_per_carat() * stone.getWeight();
                            allnames.append(stone.getName()).append(" ");
                            isFind = true;
                            break;
                        }
                    }
                    if(!isFind){
                        System.out.println("не найден");
                    }
                }
                case 3 -> {
                    Scanner scantb = new Scanner(System.in);
                    System.out.print("Введите название(драгоценные): ");
                    String NameForNecklace3 = scantb.nextLine();
                    boolean isFind = false;
                    for (Precious stone : tbstones) {

                        if (stone.getName().equals(NameForNecklace3)) {
                            System.out.println(stone);
                            totalWeight += stone.getWeight();
                            totalPrice += stone.getPrice_per_carat() * stone.getWeight();
                            allnames.append(stone.getName()).append(" ");
                            isFind = true;
                            break;
                        }
                    }
                    if(!isFind){
                        System.out.println("не найден");
                    }
                }
                case 0 -> System.out.println("выход");
                default -> System.out.println("Введите еще раз");
            }
        } while (choice != 0);
        // вывод информации об ожерелье
        System.out.println("Ожерелье:");
        System.out.println("состоит из: " + allnames);
        System.out.println("итоговый вес: " + totalWeight);
        System.out.println("итоговая цена: " + totalPrice);

    }
}


