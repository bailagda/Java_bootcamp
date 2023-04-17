package src.main.java.edu.school21.chat.repositories;

import src.main.java.edu.school21.chat.models.Message;

import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    @Override
    public Optional<Message> findById(Long id) {
        return Optional.empty();
    }
}
