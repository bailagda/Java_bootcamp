package src.main.java.edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private final int ID;
    private String Login;
    private String Password;
    private List<Chatroom> rooms;
    private List<Chatroom> socializes;

    public User(int ID, String Login, String Password, List<Chatroom> rooms, List<Chatroom> socializes) {
        this.ID = ID;
        this.Login = Login;
        this.Password = Password;
        this.rooms = rooms;
        this.socializes = socializes;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }
        User obj = (User) other;
        return this.ID == obj.ID && Objects.equals(this.Login, obj.Login) && Objects.equals(this.Password, obj.Password)
                && obj.rooms == this.rooms && obj.socializes == this.socializes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Login, Password, rooms, socializes);
    }

    @Override
    public String toString() {
        return "User : {" +
                "ID=" + ID +
                ", Login='" + Login + '\'' +
                ", Password=" + Password +
                ", rooms=" + rooms +
                ", socializes=" + socializes +
                '}';
    }

    public int getID() {
        return ID;
    }

    public List<Chatroom> getRooms() {
        return rooms;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public List<Chatroom> getSocializes() {
        return socializes;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRooms(List<Chatroom> rooms) {
        this.rooms = rooms;
    }

    public void setSocializes(List<Chatroom> socializes) {
        this.socializes = socializes;
    }
}
