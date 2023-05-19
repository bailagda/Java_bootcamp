package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
           new Product(1, "abra-cadabra", 80),
            new Product(2, "kalyaka-balyaka", 50),
            new Product(3, "sim-salabim", 70),
            new Product(4, "syaski-masyaski", 100),
            new Product(5, "trakh-tibidokh", 60),
            new Product(6, "magic!", 90)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(3, "sim-salabim", 70);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(6, "just test, not magic", 300);
    final Product EXPECTED_SAVED_PRODUCT = new Product(7, "new save", 0);
    final boolean EXPECTED_DELETED_PRODUCT = true;

    private ProductsRepository productsRepository;
    @BeforeEach
    void init() {
        DataSource ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql").addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(ds);
    }

    @Test
    void findAllTest() {
        Assertions.assertEquals((productsRepository.findAll().get(1)), EXPECTED_FIND_ALL_PRODUCTS.get(1));
    }
}
