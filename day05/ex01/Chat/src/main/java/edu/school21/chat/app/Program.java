package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message ID: ");
        if (!scanner.hasNextLong()) {
            System.out.println("Invalid id format");
            System.exit(-1);
        }
        Long id = scanner.nextLong();
        MessagesRepositoryJdbcImpl msgRepo = new MessagesRepositoryJdbcImpl();
        Optional<Message> res = msgRepo.findById(id);
        System.out.print(res.get());
    }
}
