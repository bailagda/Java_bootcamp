package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;

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
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            conn = DriverManager.getConnection(url, username, password);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }


    @Override
    public Optional<Message> findById(Long id) {

        Optional<Message> opM = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM messages_table WHERE id =";

            ResultSet rs = statement.executeQuery(sql + id);
            while(rs.next()) {
                System.out.println(rs);
            }
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
