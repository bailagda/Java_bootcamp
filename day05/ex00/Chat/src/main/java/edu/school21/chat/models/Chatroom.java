package src.main.java.edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    public final int id;
    public String name;
    public User owner;
    public List<Message> messages;

    public Chatroom(int id, String name, User owner, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.messages = messages;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }
        Chatroom obj = (Chatroom) other;
        return this.id == obj.id && Objects.equals(this.name, obj.name)
                && this.messages == obj.messages && obj.owner == this.owner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, messages);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", messages=" + messages +
                '}';
    }

    public int getId() {
        return id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

