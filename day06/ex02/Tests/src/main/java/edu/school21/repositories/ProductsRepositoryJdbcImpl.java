package edu.school21.repositories;

import edu.school21.models.Product;
import org.springframework.cglib.core.SpringNamingPolicy;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{
    private DataSource ds;
    ProductsRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement st = ds.getConnection().prepareStatement(
                    "SELECT * FROM product ORDER BY id");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Product u = new Product(
                            rs.getInt(1), rs.getString(2),
                            rs.getInt(3));
                products.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<Product> optionalProduct = null;
        try {
            Statement statement = ds.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM product WHERE id =" + id);
            rs.next();
            optionalProduct = Optional.of(
                    new Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        } catch (Exception e) {
            System.out.println("Connection failed...");
            System.exit(-1);
        }
        return optionalProduct;
    }

    @Override
    public void update(Product product) {
        PreparedStatement st3 = null;
        try {
            st3 = ds.getConnection().prepareStatement(
                    "UPDATE product SET name = ?, price = ? WHERE id = ?");
            st3.setString(1, product.getName());
            st3.setInt(2, product.getPrice());
            st3.setInt(3, product.getId());
            st3.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Product product) {
        try {
            PreparedStatement st3 = ds.getConnection().prepareStatement(
                    "Insert into product (id, name, price) VALUES (?, ?, ?)");
            st3.setInt(1, product.getId());
            st3.setString(2, product.getName());
            st3.setInt(3, product.getPrice());
            st3.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Statement statement = ds.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("DELETE FROM product WHERE id =" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
