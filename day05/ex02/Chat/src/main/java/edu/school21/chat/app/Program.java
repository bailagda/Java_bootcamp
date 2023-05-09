package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;

public class Program {
    public static void main(String args[]) {
        User creator = new User(7L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Room room = new Room(8L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(???);
        messagesRepository.save(message);
        System.out.println(message.getId()); // ex. id == 11
    }
}
