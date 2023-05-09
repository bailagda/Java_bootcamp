package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Message {
    private final int id;
    private User author;
    private Chatroom room;
    private String text;
    private Date message_date;

    public Message(int id, User author, Chatroom room, String text, Date message_date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.message_date = message_date;
    }

    @Override
    public boolean equals(Object Mess) {
        if(this == Mess) {return true;}
        Message obj = (Message) Mess;
        return this.id == obj.id && this.room == obj.room && this.author == obj.author
                && this.message_date == obj.message_date && Objects.equals(this.text, obj.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text, message_date);
    }

    @Override
    public String toString() {
        return "Message : {" +
                "\n id=" + id +
                ",\n author='" + author + '\'' +
                ",\n room=" + room +
                ",\n text=" + text +
                ",\n message_date=" + message_date +
                "\n}";
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public String getText() {
        return text;
    }

    public Date getMessage_date() {
        return message_date;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMessage_date(Date message_date) {
        this.message_date = message_date;
    }
}
