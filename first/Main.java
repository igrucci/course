import java.util.Scanner;

class CBookCard {
    private String author;
    private String title;
    private String publisher;
    private int year;
    private String isbn;
    private double rate;
    private String comment;

    public CBookCard(String author, String title, String publisher, int year, String isbn) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
        this.publisher = publisher;
        this.comment = comment;
    }

    public CBookCard() {

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }


    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Автор: " + author + "; Заглавие: " + title + "; Издательство: " + publisher +
                "; Год издания: " + year + ", ISBN: " + isbn.substring(0, 3) + " " + isbn.substring(4, 5) + " " + isbn.substring(6, 8) + " " + isbn.substring(9,15) + " " + isbn.substring(16)+ "; Рейтинг: " + rate;
    }

    public static class Main {

        public static void main(String[] args) {
            // Создание двух статических объектов

            CBookCard book1 = new CBookCard("Джорджа Оруэлл", "1984", "СМИТ-М", 2017, "978-3-16-148410-0");
            book1.setRate(4.7);
            CBookCard book2 = new CBookCard("Михаила Булгаков", "Мастер и Маргарита", "Азбука-классика", 2014, "978-4-17-258521-1");
            book2.setRate(3.5);

            Scanner scanner = new Scanner(System.in);

            int n;
            do {
                System.out.print("Введите размер(0-5): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Вы ввели не число. Введите число заново: ");
                    scanner.next();
                }
                n = scanner.nextInt();
            } while (( n < 0) || ( n > 5));
            scanner.nextLine();
            CBookCard[] books = new CBookCard[n + 2];
            books[0] = book1;
            books[1] = book2;

            for (int i = 2; i < n + 2; i++) {
                System.out.println("Книга " + ((i - 2) + 1) + ":");
                scanner.nextLine();
                System.out.print("Введите автора: ");
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        System.out.print("Вы ввели число, а не текст. Введите текст заново: ");
                        scanner.nextLine();
                    } else {
                        break;
                    }
                }
                String author = scanner.nextLine();
                System.out.print("Введите название: ");
                String title = scanner.nextLine();

                System.out.print("Введите издательство: ");
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        System.out.print("Вы ввели число, а не текст. Введите текст заново: ");
                        scanner.nextLine();
                    } else {
                        break;
                    }
                }
                String publisher = scanner.nextLine();

               int year;
                do {
                    System.out.print("Введите год издания(0-2023): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Вы ввели не число. Введите число заново: ");
                        scanner.next();
                    }
                   year = scanner.nextInt();
                } while (( year < 0) || ( year > 2023));
                scanner.nextLine();

                System.out.print("Введите ISBN: ");
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        System.out.print("Введите заново: ");
                        scanner.nextLine();
                    } else {
                        break;
                    }
                }
                String ISBN = scanner.nextLine();


                // Создаем объект и заполняем его поля
//                CBookCard book = new CBookCard();
//
//                book.setAuthor(author);
//                book.setTitle(title);
//                book.setPublisher(publisher);
//                book.setYear(year);
//                book.setISBN(ISBN);


                books[i] = new CBookCard(author, title, publisher, year, ISBN);



                while (true) {
                System.out.print("Введите рейтинг (от 0 до 5): ");
                 if (scanner.hasNextDouble()) {
                   double  rate = scanner.nextDouble();
                     books[i].setRate(rate);
                     if (rate >= 0 && rate <= 5) {
                        break;
                     } else {
                         System.out.println("Рейтинг должен быть от 0 до 5");
                     }
                 } else {
                     System.out.println("Вы ввели не число. Попробуйте еще раз.");
                     scanner.next();
                 }
             }
            }
            // Вывод списка книг
            // выводим массив книг до сортировки
            System.out.println("==============================================================");
            System.out.println("Массив книг до сортировки:");
            // Вывод информации о книгах
            for (CBookCard book : books) {
                System.out.println(book.toString());
            }
    // сортируем массив по году издания
            int g = books.length;
            for (int k = 0; k < g; k++) {
                for (int j = 1; j < g - k; j++) {
                    if (books[j - 1].getYear() > books[j].getYear()) {
                        CBookCard temp = books[j - 1];
                        books[j - 1] = books[j];
                        books[j] = temp;
                    }
                }
            }

    // выводим отсортированный
            System.out.println("==============================================================");
            System.out.println("Массив книг после сортировки:");
            for (CBookCard book : books) {
                System.out.println(book.toString());
            }

        }
    }
}
