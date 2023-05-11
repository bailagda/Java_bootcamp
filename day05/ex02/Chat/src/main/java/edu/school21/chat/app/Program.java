package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        User creator = new User(3L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(3L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "This is test message for ex02",
                java.time.LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl();
        messagesRepository.save(message);
        System.out.println(message.getId()); // ex. id == 6
    }
}
