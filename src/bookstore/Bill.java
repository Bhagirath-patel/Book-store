/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author bhagirath
 */
public class Bill {

        String cusName;
        String bookName[] = new String[100];
        int stock;
        int totalAmount;

    Bill(String cusName, String bookName[] , int stock , int totalAmount) {
        this.cusName = cusName;
        this.bookName = bookName;
        this.stock = stock;
        this.totalAmount = totalAmount;
    }

    void billPrint() {
        System.out.println("Custmer Name :" + this.cusName);
        System.out.print(" Custmer Name :");
               for(int i = 0 ; bookName[i] !=null ; i++){
                System.out.print(this.bookName[i]+",");
              }
        System.out.println(" Stock of Book : " + this.stock);
        System.out.println(" Total Amount :" + this.totalAmount);
    }

}
