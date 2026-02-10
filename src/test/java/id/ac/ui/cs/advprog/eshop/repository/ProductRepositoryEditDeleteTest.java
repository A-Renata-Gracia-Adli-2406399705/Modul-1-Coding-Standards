package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryEditDeleteTest {

    private ProductRepository repository;
    private Product product;

    @BeforeEach
    void setUp() {
        repository = new ProductRepository();

        product = new Product();
        product.setProductId("1");
        product.setProductName("Buku");
        product.setProductQuantity(10);

        repository.create(product);
    }

    @Test
    void edit_existingProduct_success() {
        Product updated = new Product();
        updated.setProductId("1");
        updated.setProductName("Pensil");
        updated.setProductQuantity(20);
        repository.update(updated);
        Product result = repository.findById("1");
        assertEquals("Pensil", result.getProductName());
        assertEquals(20, result.getProductQuantity());
    }

    @Test
    void edit_nonExistingProduct_failed() {
        Product updated = new Product();
        updated.setProductId("999");
        updated.setProductName("Pulpen");
        updated.setProductQuantity(5);
        repository.update(updated);
        Product result = repository.findById("999");
        assertNull(result);
    }

    @Test
    void delete_existingProduct_success() {
        repository.delete("1");
        Product result = repository.findById("1");
        assertNull(result);
    }

    @Test
    void delete_nonExistingProduct_failed() {
        repository.delete("999");
        Product result = repository.findById("1");
        assertNotNull(result);
    }
}
