package src.main.java.edu.school21.chat.repositories;

import src.main.java.edu.school21.chat.models.Message;

import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Message> findById(Long id) throws SQLException;
}

