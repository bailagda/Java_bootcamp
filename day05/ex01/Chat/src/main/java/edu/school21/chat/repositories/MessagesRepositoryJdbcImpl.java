package src.main.java.edu.school21.chat.repositories;

import src.main.java.edu.school21.chat.models.Message;

import javax.sound.midi.Soundbank;
import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
//    private final DataSource ds;

//    public MessagesRepositoryJdbcImpl(DataSource ds) {
//        this.ds = ds;
//    }

    @Override
    public Optional<Message> findById(Long id) {
        Optional<Message> opM = null;
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "root";
            String password = "password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            Connection conn = DriverManager.getConnection(url, username, password);

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM messages_table WHERE id =" + id);
            opM = Optional.of(new Message(rs.getInt(1), null, null, null, null));


//                Connection con = ds.getConnection();
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM messages_table WHERE id =" + id);
//                opM = Optional.of(new Message(rs.getInt(1), null, null, null, null));
        } catch (Exception e) {
            System.out.println("Connection failed...");
        }
        return opM;
    }
}
