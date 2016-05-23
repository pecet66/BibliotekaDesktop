/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Paweł
 */
public class DatabaseTest {
    
    static public void printEgzemplarz(List<Egzemplarz> egzemplarze) {
        for(Egzemplarz egz: egzemplarze) {
            System.out.println(egz);
            System.out.println("\n");
        }
    }
    
    
    public static void main(String[] args) {
         Date date = new Date();
         Database baza= new Database();
         Timestamp time = new Timestamp(date.getTime());
         System.out.print(time + "\n");
         
         List<Egzemplarz> selectEgzemplarzList = baza.selectEgzemplarzList("","","","","","","","","");
         DatabaseTest.printEgzemplarz(selectEgzemplarzList);
         
         baza.close();
     }
         
         
         
}
