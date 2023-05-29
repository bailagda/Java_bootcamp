package edu.school21.repositories;

import edu.school21.models.Product;
import edu.school21.numbers.IllegalNumberException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductsRepositoryJdbcImplTest {
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
           new Product(1, "abra-cadabra", 80),
            new Product(2, "kalyaka-balyaka", 50),
            new Product(3, "sim-salabim", 70),
            new Product(4, "syaski-masyaski", 100),
            new Product(5, "trakh-tibidokh", 60),
            new Product(6, "magic!", 90)
    );
    final Optional<Product> EXPECTED_FIND_BY_ID_PRODUCT = Optional.of(new Product(3, "sim-salabim", 70));
    final Product EXPECTED_UPDATED_PRODUCT = new Product(6, "just test, not magic", 300);
    final Product EXPECTED_SAVED_PRODUCT = new Product(7, "new save", 0);
    final boolean EXPECTED_DELETED_PRODUCT = true;


    private EmbeddedDatabase ds;
    private ProductsRepository productsRepository;
    @BeforeEach
    void init() {
        ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql").addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(ds);
    }

    @Test
    void findAllTest() {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @ParameterizedTest
    @ValueSource(longs = 3)
    void findByIdTest(long id) {
        Assertions.assertEquals(productsRepository.findById(id), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @ParameterizedTest
    @ValueSource(longs = 6)
    void updateTest(long id) throws SQLException {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(productsRepository.findById(id), Optional.of(EXPECTED_UPDATED_PRODUCT));
    }

    @ParameterizedTest
    @ValueSource(longs = 7)
    void saveTest(long id) throws SQLException {
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(Optional.of(EXPECTED_SAVED_PRODUCT), productsRepository.findById(id));
    }

    @ParameterizedTest
    @ValueSource(longs = 1)
    void deleteTest(long id) throws SQLException {
        boolean res = false;
            productsRepository.delete(id);
        Assertions.assertNotEquals(res, EXPECTED_DELETED_PRODUCT);
    }

    @AfterEach
    public void end() {
        ds.shutdown();
    }
}
