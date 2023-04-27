package edu.school21.chat.app;

import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.models.Message;
import java.sql.SQLException;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        MessagesRepositoryJdbcImpl msgRepo = new MessagesRepositoryJdbcImpl();
        Optional<Message> res = msgRepo.findById(1L);
        System.out.print(res);
    }
}
