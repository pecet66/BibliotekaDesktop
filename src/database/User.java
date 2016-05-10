/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Timestamp;

/**
 *
 * @author Paweł
 */
public class User {
    
    private String nick;
    private String password;
    private Boolean ban;
    private Boolean admin;
    private Timestamp joinDate;

    public User(String nick, String password, Timestamp joinDate, Boolean admin, Boolean ban) {
        this.nick = nick;
        this.password = password;
        this.ban = ban;
        this.admin = admin;
        this.joinDate = joinDate;
    }

    public User(String nick) {
        this.nick = nick;
        this.password = "";
        this.ban = false;
        this.admin = false;
        this.joinDate = null;
    }

    public User(String nick, Boolean ban, Boolean admin) {
        this.nick = nick;
        this.password = "";
        this.ban = ban;
        this.admin = admin;
        this.joinDate = null;
    }

    public User() {
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public Boolean getBan() {
        return ban;
    }
        

    @Override
    public String toString() {
        return "User{" + "nick=" + nick + ", password=" + password + ", ban=" + ban + ", admin=" + admin + ", joinDate=" + joinDate + '}';
    }
    
    
    
}
