package bookstore;

import java.lang.*;
import java.util.*;

/**
 *
 * @author bhagirath
 */

public class Bookstore {

    Book books[] = new Book[1000];
    Bill bills[] = new Bill[1000];
    int bill_position = 0;
    int position = 0;

    /**
     * @param args the command line arguments
     */
    void addBook() {
        // String name, 
        // int price, stock
        Book b = new Book();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Name");
        b.name = sc.next();
        System.out.println("Enter Price");
        b.price = sc.nextInt();
        System.out.println("Enter stock of book");
        b.stock = sc.nextInt();
        for (int i = 0; i < position; i++) {
            if (b.name.equals(books[i].name)) {
                System.out.println("This book is already available . Try again");
                return;
            }
        }
        books[position] = b;
        position++;
    }

    void print() {
        for (int i = 0; i < position; i++) {
            books[i].print();
        }

    }

    void billPrint() {
        for (int i = 0; i < bill_position; i++) {
            System.out.println("Custmer Name :" + bills[i].cusName);
            System.out.println("Book Name " + bills[i].name);
            System.out.println("Stock of Book :" + bills[i].stock);
            System.out.println("Total Amount :" + bills[i].total_amount);

        }

    }

    void stock() {
        Book b = new Book();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Name");
        b.name = sc.next();
        for (int i = 0; i < position; i++) {
            if (b.name.equals(books[i].name)) {
                System.out.println("Total stock of book :" + books[i].stock);
                return;
            }
        }
        System.out.println("This book is not available . Try again");

    }

    // Create Bill
    void bill() {
        Bill bl = new Bill();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter custmer Name");
        bl.cusName = sc.next();
        bl.name = "";
        bl.stock = 0;
        bl.total_amount = 0;
        int ch = 0;
        boolean x = true;
        while (x) {

            System.out.println("Enter Book Name");
            String name = sc.next();
            System.out.println("Enter number of Book");
            int numBook = sc.nextInt();

            for (int i = 0; i < position; i++) {
                if (name.equals(books[i].name) && numBook <= books[i].stock) {
                    if (bl.name.length() > 0) {
                        bl.name = bl.name + "," + name;
                    } else {
                        bl.name = name;
                    }
                    bl.total_amount += numBook * books[i].price;

                    bl.stock += numBook;

                    books[i].stock -= numBook;

                    System.out.println("Enter 0 to exit and any other to add more book");

                    ch = sc.nextInt();
                    if (ch == 0) {
                        bills[bill_position] = bl;
                        bill_position++;
                        return;
                    }
                }
                if (ch != 0) {
                    continue;
                }
                System.out.println("Book not available");
                System.out.println("Enter 0 to exit and any other to add more book");

                ch = sc.nextInt();
                if (ch == 0) {
                    return;
                }

            }

        }

    }

    // End Bill Block
    public static void main(String[] args) {
        // TODO code application logic here
        Bookstore bs = new Bookstore();
        Scanner sc = new Scanner(System.in);
        String name;
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
                    bs.addBook();
                    System.out.println("Successfully Added");
                    break;
                }
                case 2: {
                    bs.print();
                    break;
                }
                case 3: {
                    bs.bill();
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
