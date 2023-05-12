package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.UsersRepository;
import edu.school21.chat.repositories.UsersRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Program {
    static private HikariConfig config = new HikariConfig();
    public static void main(String[] args) throws SQLException {
        config.setJdbcUrl("jdbc:postgresql://localhost:5433/first_db");
        config.setUsername("postgres");
        config.setPassword("123");
        HikariDataSource hikariDataSource = new HikariDataSource(config);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(hikariDataSource);
        List<User> resultList = usersRepository.findAll(0,5);
        for (User u: resultList) {
            System.out.println(u);
        }
    }
}
