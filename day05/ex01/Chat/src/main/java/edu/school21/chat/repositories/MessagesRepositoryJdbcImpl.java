package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private static final String url = "jdbc:postgresql://localhost:5433/first_db";
    private static final String username = "postgres";
    private static final String password = "123";
    static Connection conn;
    static {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(username);
            config.setPassword(password);

            HikariDataSource hikariDataSource = new HikariDataSource(config);
            if (hikariDataSource.getConnection() == null) {   //hikariDataSource.isClosed()
                throw new SQLException("Database connection failed");
            }
            System.out.println("Database successfully Connection");
            conn = hikariDataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("Connection failed from createDataSourceConnection: " + e);
        }
    }

    @Override
    public Optional<Message> findById(Long id) {
        User author = new User(1, "login", "password", null, null);
        Chatroom room = new Chatroom(1, "room", null, null);

        Optional<Message> opM = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM messages_table WHERE id =" + id);
            rs.next();
            opM = Optional.of(new Message(rs.getInt(1), author, room, null, null));
        } catch (Exception e) {
            System.out.println("Connection failed...");
            System.exit(-1);
        }
        return opM;
    }
}
