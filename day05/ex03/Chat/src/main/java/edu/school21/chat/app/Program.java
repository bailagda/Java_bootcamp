package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl();
        Optional<Message> messageOptional = messagesRepository.findById(11L);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("Test message ex03");
            message.setMessage_date(null);
            messagesRepository.update(message);
        }
    }
}
