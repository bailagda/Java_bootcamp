package edu.school21.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmbeddedDataSourceTest {
    private DataSource ds;
    @BeforeEach
    void init() {
        ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql").addScript("data.sql")
                .build();
    }

    @Test
    void testDataBase() throws SQLException {
        Connection con = ds.getConnection();
        Statement st1 = con.createStatement();
        ResultSet rs = st1.executeQuery("select * from product");
        rs.next();
        rs.next();
        Assertions.assertNotNull(rs.getString(2));
    }
}
