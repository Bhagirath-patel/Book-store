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
public class Book {
    String name;
    int price;
    int stock;
    
    // Print
   
   Book(String name  , int price , int stock){
       this.name = name;
       this.price = price;
       this.stock = stock;   
   }
    void print()
    {
        System.out.println("Book Name :"+ this.name
                + "  "+" Price of book : "+ this.price
                + "  "+" Stock of Book :"+ this.stock);

    }  
}
