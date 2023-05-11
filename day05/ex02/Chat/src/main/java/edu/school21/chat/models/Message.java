package edu.school21.chat.models;

import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Message {
    private final Long id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime message_date;
    @Nullable
    public Message(Long id, User author, Chatroom room, String text, LocalDateTime message_date) {
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
                "\n id = " + id +
                ",\n author = " + author +
                ",\n room = " + room +
                ",\n text = " + text +
                ",\n message_date = " + message_date +
                "\n}";
    }

    public Long getId() {
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

    public LocalDateTime getMessage_date() {
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

    public void setMessage_date(LocalDateTime message_date) {
        this.message_date = message_date;
    }
}
