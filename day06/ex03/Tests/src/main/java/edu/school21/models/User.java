package edu.school21.models;

public class User {
    Integer identifier;
    String login;
    String password;
    boolean status;
    public User(Integer id, String log, String passw, boolean stats) {
        identifier = id;
        login = log;
        password = passw;
        status = stats;
    }

    public boolean getStatus() {
        return status;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
