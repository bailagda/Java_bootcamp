package edu.school21.chat.repositories;

import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    static Connection conn;

    public UsersRepositoryJdbcImpl(DataSource ds) {
        try {
            if (ds.getConnection() == null) {
                throw new SQLException("Database connection failed");
            }
            System.out.println("Database successfully Connection");
            conn = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<User> findAll(int page, int size) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT * FROM users_table ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            st.setInt(1, page);
            st.setInt(2, size);

            ResultSet rs = st.executeQuery();

            for(int i = size; i > 0; --i) {
                if(rs.next()) {
                    User u = new User(
                            rs.getLong(1), rs.getString(2),
                            rs.getString(3), null, null);
                    users.add(u);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
