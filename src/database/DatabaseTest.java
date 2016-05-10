/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Paweł
 */
public class DatabaseTest {
    
    static public void printUsers(List<User> users) {
        for(User user: users) {
            System.out.println(user);
            System.out.println("\n");
        }
    }
    
    static public void printMessages(List<Message> messages) {
        for(Message message: messages) {
            System.out.println(message);
            System.out.println("\n");
        }
    }
    
    public static void main(String[] args) {
         Date date = new Date();
         Database baza= new Database();
         Timestamp time = new Timestamp(date.getTime());
         System.out.print(time + "\n");
         //System.out.print(date + "\n");
         
//         baza.insertUser("piotr", "haslo",time, false);
//         baza.insertUser("piotr1", "haslo",time, true);
//         baza.insertUser("piotr2", "haslo",time, true);
//         baza.insertUser("piotr3", "haslo",time, true);
         
//         baza.insertMessage(time, "wiadomosc1", "piotr"); //*3
//         
//         baza.insertMessage(time, "wiadomosc1", "piotr1");
//         
//         baza.insertMessage(time, "wiadomosc1", "piotr2");
//        
//         baza.insertMessage(time, "wiadomosc1", "piotr3");
         
//        User selectUser = baza.selectUser("piotr1");
//        System.out.println(selectUser);
         
//        List<User> selectAdminList = baza.selectAdminList();
//        //printUsers(selectAdminList);
//        
//        //baza.banUser("piotr");
//        List<User> selectBanList = baza.selectBanList();
//        printUsers(selectBanList);
//        
//        
//        baza.unbanUser("piotr");
//        List<User> selectBanList1 = baza.selectBanList();
//        printUsers(selectBanList1);
//        
//        System.out.println("\n tu jestem po odbanowaniu \n");
//

//        
//        Timestamp timestamp1 = Timestamp.valueOf("2015-12-31 14:54:48.575");
//        Timestamp timestamp2 = Timestamp.valueOf("2015-12-31 14:56:54.869");
//        Timestamp timestamp3 = Timestamp.valueOf("2015-12-31 14:58:33.954");
//        
//        Timestamp timestamp4 = Timestamp.valueOf("2015-12-31 12:31:00.000");
//        Timestamp timestamp5 = Timestamp.valueOf("2015-12-31 14:56:00.000");
//        
//        List<Message> messagesTill = baza.selectMessagesListTillTimestamp(timestamp4);
//        List<Message> messagesTillUntill = baza.selectMessagesListTillTimestamp(timestamp4, timestamp5);
//        printMessages(messagesTill);
        //printMessages(messagesTillUntill);
         
//         User janek= new User("janek","asdf",new Timestamp(date.getTime()),false,false);
//         Message list= new Message(new Timestamp(date.getTime()), "wiadomosc w butelce", "janek");
//        
//         baza.insertUser(janek);
//         baza.insertMessage(list);
//         
         
//         baza.deleteUser("janek");
         
         
         
     }
         
         
         
}
