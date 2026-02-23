package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    private ProductServiceImpl service;
    private ProductRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(ProductRepository.class);
        service = new ProductServiceImpl(repository);
    }

    @Test
    void testCreateGenerateIdIfNull() {
        Product product = new Product();
        product.setProductId(null);

        when(repository.create(any())).thenReturn(product);

        Product result = service.create(product);

        assertNotNull(result.getProductId());
        verify(repository).create(product);
    }

    @Test
    void testCreateWithExistingId() {
        Product product = new Product();
        product.setProductId("existing-id");

        when(repository.create(any())).thenReturn(product);

        Product result = service.create(product);

        assertEquals("existing-id", result.getProductId());
        verify(repository).create(product);
    }

    @Test
    void testCreateGenerateIdIfEmpty() {
        Product product = new Product();
        product.setProductId("");

        when(repository.create(any())).thenReturn(product);

        Product result = service.create(product);

        assertNotNull(result.getProductId());
        assertFalse(result.getProductId().isEmpty());
        verify(repository).create(product);
    }

    @Test
    void testFindAll() {
        Product product = new Product();
        product.setProductId("1");

        Iterator<Product> iterator = Arrays.asList(product).iterator();
        when(repository.findAll()).thenReturn(iterator);

        assertEquals(1, service.findAll().size());
    }

    @Test
    void testFindById() {
        Product product = new Product();
        when(repository.findById("1")).thenReturn(product);

        assertNotNull(service.findById("1"));
    }

    @Test
    void testUpdate() {
        Product product = new Product();
        service.update(product);

        verify(repository).update(product);
    }

    @Test
    void testDelete() {
        service.delete("1");
        verify(repository).delete("1");
    }
}