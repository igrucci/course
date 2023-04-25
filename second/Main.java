import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("type the quantity of super stones");
        int n = scanner.nextInt();


        SuperStone[] spstones = new SuperStone[n];
        for (int i = 0; i < n; i++) {
            System.out.println("==============================================================");
            System.out.print("Type the name of super stone " + i + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("invalid response, type again: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }

            String name = scanner.next();
            System.out.println(name +" for anton");


            System.out.print("Type the weight of super stone " + i + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("invalid response: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();


            System.out.print("Type the parametr1 of super stone " + i + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("invalid response, type again: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String parametr1 = scanner.next();

            System.out.print("Type the price per carat of super stone " + i + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("invalid response: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();



            spstones[i] = new SuperStone(name, parametr1, weight, price_per_carat);
            System.out.println("added");

        }

        System.out.println("==============================================================");

        Scanner scannerspsp = new Scanner(System.in);
        System.out.println("type the quantity of super stones");
        int m = scannerspsp.nextInt();

        SuperSuperStone[] spspstones = new SuperSuperStone[m];
        for (int k = 0; k < m; k++) {
            System.out.println("==============================================================");
            System.out.print("Type the name of super super stone " + k + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("invalid response, type again: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String name = scanner.next();


            System.out.print("Type the weight of super stone " + k + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("invalid response: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();


            System.out.print("Type the parametr2 of super super stone " + k + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("invalid response, type again: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String parametr2 = scanner.next();

            System.out.print("Type the price per carat of super super stone " + k + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("invalid response: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();

            SuperSuperStone spspstone = new SuperSuperStone(name, parametr2, weight, price_per_carat);

            spspstone.setName(name);
            spspstone.setParametr2(parametr2);
            spspstone.setWeight(weight);
            spspstone.setPrice_per_carat(price_per_carat);

            spspstones[k] = new SuperSuperStone(name, parametr2, weight, price_per_carat);

        }

        System.out.println("==============================================================");

        Scanner scannertb = new Scanner(System.in);
        System.out.println("type the quantity of the best stones");
        int p = scannertb.nextInt();


        TheBestStone[] tbstones = new TheBestStone[p];
        for (int j = 0; j < p; j++) {
            System.out.println("==============================================================");
            System.out.print("Type the name of the best stone " + j + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("invalid response, type again: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String name = scanner.next();


            System.out.print("Type the weight of the best stone " + j + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("invalid response: ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            scanner.nextLine();


            System.out.print("Type the parametr3 of the best stone " + j + ": ");
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.print("invalid response, type again: ");
                    scanner.nextLine();
                } else {
                    break;
                }
            }
            String parametr3 = scanner.next();

            System.out.print("Type the price per carat of the best stone " + j + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("invalid response: ");
                scanner.next();
            }
            double price_per_carat = scanner.nextDouble();
            scanner.nextLine();

            tbstones[j] = new TheBestStone(name, parametr3, weight, price_per_carat);
           }

        System.out.println("==============================================================");


        // Вывод информации
        System.out.println("Super Stone:");
        for (SuperStone stone : spstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("Super Super Stones:");
        for (SuperSuperStone stone : spspstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("The Best Stones:");
        for (TheBestStone stone : tbstones) {
            System.out.println(stone.toString());
            System.out.println("--------------------------------------------------------------");
        }


        double totalWeight = 0;
        double totalPrice = 0;
        StringBuilder allnames = new StringBuilder();
        Scanner scanforchoice = new Scanner(System.in);

        int choice;

        do {
            System.out.println("menu:");
            System.out.println("1. super");
            System.out.println("2. supersuper");
            System.out.println("3. thebest");
            System.out.println("0. calculate");

            System.out.print("choose: ");
            choice =scanforchoice.nextInt();

            switch (choice) {
                case 1 -> {
                    Scanner scansp = new Scanner(System.in);
                    System.out.print("type the name(SuperStone): ");
                    String NameForNecklace1 = scansp.nextLine();
                   boolean isFind = false;
                    for (SuperStone stone : spstones) {

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
                        System.out.println("not found");
                    }
                }
                case 2 -> {
                    Scanner scanspsp = new Scanner(System.in);
                    System.out.print("type the name(SuperSuperStone): ");
                    String NameForNecklace2 = scanspsp.nextLine();
                    boolean isFind = false;
                    for (SuperSuperStone stone : spspstones) {

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
                        System.out.println("not found");
                    }
                }
                case 3 -> {
                    Scanner scantb = new Scanner(System.in);
                    System.out.print("type the name(TheBestStone): ");
                    String NameForNecklace3 = scantb.nextLine();
                    boolean isFind = false;
                    for (TheBestStone stone : tbstones) {

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
                        System.out.println("not found");
                    }
                }
                case 0 -> System.out.println("exit");
                default -> System.out.println("try again");
            }
        } while (choice != 0);
        System.out.println("ur necklace:");
        System.out.println("consist of: " + allnames);
        System.out.println("total weight: " + totalWeight);
        System.out.println("total price: " + totalPrice);

        }
}


