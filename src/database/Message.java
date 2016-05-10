/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.awt.Color;
import java.sql.Timestamp;



/**
 *
 * @author Kamil
 */

public class Message implements java.io.Serializable{
    
    
    public enum EType {
        MESSAGE, REGISTRATION, LOGIN, LOGOUT, KICK, BAN, UNBAN, USERLIST, BANLIST
    }
    
    private EType type;
    private Timestamp date;
    private String nick;
    private String content;
    private Color color;
    
    public Message() {
        this.type = null;
        this.date = null;
        this.nick = null;
        this.content = null;
        this.color = null;
    }

    public Message(EType type, Timestamp date, String nick, String content, Color color) {
        this.type = type;
        this.date = date;
        this.nick = nick;
        this.content = content;
        this.color = color;
    }
    
    
    
    public Message(Timestamp date, String content, String nick) {
        this.date = date;
        this.nick = nick;
        this.content = content;
    }


        

    public Timestamp getDate() {
        return date;
    }

    public String getNick() {
        return nick;
    }

    public String getContent() {
        return content;
    }
    
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Message{" + "type=" + type + ", date=" + date + ", nick=" + nick + ", content=" + content + ", color=" + color + '}';
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
    
}
