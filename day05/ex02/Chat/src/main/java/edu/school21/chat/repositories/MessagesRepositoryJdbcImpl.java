package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.*;
import java.util.Optional;

import static java.sql.Time.valueOf;

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
        Optional<Message> opM = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM messages_table WHERE id =" + id);
            rs.next();
            User author = new User(rs.getLong(2), "login", "password", null, null);
            Chatroom room = new Chatroom(rs.getLong(3), "room", null, null);
            opM = Optional.of(new Message(rs.getLong(1), author, room, null, null));
        } catch (Exception e) {
            System.out.println("Connection failed...");
            System.exit(-1);
        }
        return opM;
    }

    @Override
    public void save(Message message) throws RuntimeException {
        try {
            Statement st1 = conn.createStatement();
            Statement st2 = conn.createStatement();
            PreparedStatement st3 = conn.prepareStatement(
                    "Insert into messages_table (author_id, room_id, text, message_date) VALUES (?, ?, ?, ?)");

            ResultSet checkAuthor = st1.executeQuery(
                    "SELECT * FROM users_table WHERE id =" + message.getAuthor().getID());
            ResultSet checkRoom = st2.executeQuery(
                    "SELECT * FROM chatrooms_table WHERE id =" + message.getRoom().getId());
            checkRoom.next();
            checkAuthor.next();

            if(checkRoom.getString(1) == null || checkAuthor.getString(1) == null) {
                throw new NotSavedSubEntityException();
            }
            st3.setLong(1, message.getAuthor().getID());
            st3.setLong(2, message.getRoom().getId());
            st3.setString(3, message.getText());
            st3.setTimestamp(4, java.sql.Timestamp.valueOf(message.getMessage_date()));
            st3.execute();

            ResultSet rs = st1.executeQuery("SELECT * FROM messages_table ORDER BY id DESC LIMIT 1");
            rs.next();
            message.setId(rs.getLong(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
