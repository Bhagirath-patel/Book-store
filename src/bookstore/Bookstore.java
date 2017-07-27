package bookstore;

import java.util.*;

/**
 *
 * @author bhagirath
 */
public class Bookstore {

    Scanner sc = new Scanner(System.in);
    Book books[] = new Book[1000];
    Bill bills[] = new Bill[1000];
    int bill_position = 0;
    int position = 0;

    /**
     * @param args the command line arguments
     */
    Book checkBook(String name) {

        for (int i = 0; i < position; i++) {
            if (name.equals(books[i].name)) {
                return books[i];
            }
        }
        return null;
    }

    Book getBook() {

        System.out.println("Enter Book Name");
        String name = sc.next();
        Book b1 = checkBook(name);

        if (b1 == null) {
            System.out.println("Enter Price");
        }
        int price = sc.nextInt();
        System.out.println("Enter stock of book");
        int stock = sc.nextInt();

        return new Book(name, price, stock);

    }

    void addBook(Book bl) {

        books[position] = bl;
        position++;

    }

    void print() {
        for (int i = 0; i < position; i++) {
            books[i].print();
        }
    }

    void billPrint() {
        for (int i = 0; i < bill_position; i++) {
            bills[i].billPrint();
        }
    }
// Stock of book

    void stock() {

        System.out.println("Enter Book Name");
        String name = sc.next();

        Book b = checkBook(name);
        if (!(b == null)) {
            System.out.println("Total stock of book :" + b.stock);
        }
    }
    //       End Stock Function 

    Bill getBill() {

        System.out.println("Enter custmer Name");
        String cusName = sc.next();
        String bookName[] = new String[100];
        int stock = 0;
        int totalAmount = 0;
        int ch;
        int book_position = 0;
        boolean continueInput = true;
        while (continueInput) {
            System.out.println("Enter Book Name");
            String name = sc.next();
            System.out.println("Enter number of Book");
            int numBook = sc.nextInt();
            Book b = checkBook(name);
            if (!(b == null) && numBook <= b.stock) {
                bookName[book_position] = name;
                book_position++;
                stock += numBook;
                totalAmount += numBook * b.price;
                b.stock -= numBook;
                System.out.println("Enter 0 to exit and any other to add more book");
                ch = sc.nextInt();
                if (ch == 0) {
                    return new Bill(cusName, bookName , stock, totalAmount);
                }
            } else {
                System.out.println("Book not available");
                System.out.println("Enter 0 to exit and any other to add more book");

                ch = sc.nextInt();
                if (ch == 0) {
                    return new Bill(cusName, bookName, stock, totalAmount);
                }
            }
        }
        return null;
    }

    //       Create Bill
    void bill(Bill bl) {
        bills[bill_position] = bl;
        bill_position++;
    }

    // End Bill Block
    public static void main(String[] args) {
        // TODO code application logic here
        Bookstore bs = new Bookstore();
        Scanner sc = new Scanner(System.in);
        boolean x = true;
        while (x) {
            System.out.println("0. Exit");
            System.out.println("1. Add New Book");
            System.out.println("2. Print Book");
            System.out.println("3. Bill");
            System.out.println("4. Stock");
            System.out.println("5. Print all bill");
            System.out.println("Enter Choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 0: {
                    x = false;
                    break;
                }
                case 1: {
                    Book b1 = bs.getBook();
                    if (b1 != null) {
                        bs.addBook(b1);
                        System.out.println("Successfully Added");
                    }
                    break;
                }
                case 2: {
                    bs.print();
                    break;
                }
                case 3: {
                    Bill bl = bs.getBill();
                    bs.bill(bl);
                    break;
                }
                case 4: {
                    bs.stock();
                    break;
                }
                case 5: {
                    bs.billPrint();
                    break;
                }
                default: {
                    System.out.println("4. Print b/w 0 to 5");
                }
            }
        }
    }
}
