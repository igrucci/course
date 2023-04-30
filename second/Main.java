import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество super stones");
        int n = scanner.nextInt();


        Ordinary[] spstones = new Ordinary[n];
        for (int i = 0; i < n; i++) {
            System.out.println("==============================================================");
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


            System.out.print("Введите вес камня " + i + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();


            System.out.print("Введите параметр1 " + i + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String parametr1 = scanner.next();

            System.out.print("Введите цену за карат " + i + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();



            spstones[i] = new Ordinary(name, parametr1, weight, price_per_carat);

        }

        System.out.println("==============================================================");

        Scanner scannerspsp = new Scanner(System.in);
        System.out.println("Введите количество super stones");
        int m = scannerspsp.nextInt();

        SemiPrecious[] spspstones = new SemiPrecious[m];
        for (int k = 0; k < m; k++) {
            System.out.println("==============================================================");
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


            System.out.print("Введите вес " + k + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();


            System.out.print("Введите параметр2 " + k + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String parametr2 = scanner.next();

            System.out.print("Введите цену за карат " + k + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();

            SemiPrecious spspstone = new SemiPrecious(name, parametr2, weight, price_per_carat);

            spspstone.setName(name);
            spspstone.setTransparency(parametr2);
            spspstone.setWeight(weight);
            spspstone.setPrice_per_carat(price_per_carat);

            spspstones[k] = new SemiPrecious(name, parametr2, weight, price_per_carat);

        }

        System.out.println("==============================================================");

        Scanner scannertb = new Scanner(System.in);
        System.out.println("Введите количество the best stones");
        int p = scannertb.nextInt();


        Precious[] tbstones = new Precious[p];
        for (int j = 0; j < p; j++) {
            System.out.println("==============================================================");
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


            System.out.print("Введите вес " + j + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();


            System.out.print("Введите параметр3" + j + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("ошибка ввода, введите еще раз: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String parametr3 = scanner.next();

            System.out.print("Введите цену за карат " + j + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("ошибка ввода, введите еще раз: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();

            tbstones[j] = new Precious(name, parametr3, weight, price_per_carat);
        }

        System.out.println("==============================================================");


        // Вывод информации
        System.out.println("Super Stone:");
        for (Ordinary stone : spstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("Super Super Stones:");
        for (SemiPrecious stone : spspstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("The Best Stones:");
        for (Precious stone : tbstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }


        double totalWeight = 0;
        double totalPrice = 0;
        StringBuilder allnames = new StringBuilder();
        Scanner scanforchoice = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. super");
            System.out.println("2. supersuper");
            System.out.println("3. thebest");
            System.out.println("0. calculate");

            System.out.print("Выберите: ");
            choice =scanforchoice.nextInt();

            switch (choice) {
                case 1 -> {
                    Scanner scansp = new Scanner(System.in);
                    System.out.print("Введите название(SuperStone): ");
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
                    System.out.print("Введите название(SuperSuperStone): ");
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
                    System.out.print("Введите название(TheBestStone): ");
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
        System.out.println("Ожерелье:");
        System.out.println("состоит из: " + allnames);
        System.out.println("итоговый вес: " + totalWeight);
        System.out.println("итоговая цена: " + totalPrice);

    }
}


