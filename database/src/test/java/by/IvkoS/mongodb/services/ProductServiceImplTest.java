package by.IvkoS.mongodb.services;

import by.IvkoS.mongodb.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mongo-db.xml")
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Test
    public void add() throws Exception {
        Product product = new Product("test", "test", "test", "test", 11, "test");
        int count = productService.getAll().size();
        productService.add(product);
        productService.remove(product.getId());
        assertEquals(count, productService.getAll().size());
    }

    @Test
    public void update() throws Exception {
        Product product = new Product("test", "test", "test", "test", 11, "test");
        int count = productService.getAll().size();
        productService.add(product);
        product.setName("test1test1");
        productService.update(product);
        assertEquals(productService.get(product.getId()).getName(), "test1test1");
        productService.remove(product.getId());
        assertEquals(count, productService.getAll().size());
    }

    @Test
    public void get() throws Exception {
        Product product = new Product("test", "test", "test","test", 11, "test");
        int count = productService.getAll().size();
        productService.add(product);
        Product product2 = productService.get(product.getId());
        assertEquals(product, product2);
        productService.remove(product.getId());
        assertEquals(count, productService.getAll().size());
    }

    @Test
    public void getAll() throws Exception {
        Product product = new Product("test4", "test4", "test4", "test",11, "test");
        Product product1 = new Product("test4", "test4", "test4","test", 11, "test");
        int count = productService.getAll().size();
        productService.add(product);
        productService.add(product1);
        assertEquals(productService.getAll().size(), 2);
        productService.remove(product.getId());
        productService.remove(product1.getId());
        assertEquals(count, productService.getAll().size());
    }

    @Test
    public void remove() throws Exception {
        Product product = new Product("test5", "test5", "test5","test", 11, "test");
        int count = productService.getAll().size();
        productService.add(product);
        productService.remove(product.getId());
        assertEquals(count, productService.getAll().size());
    }

    @Test
    public void getAllByType() throws Exception {
        int count = productService.getAll().size();
        Product product1 = new Product("test1", "test1", "test2","test", 11.20, "test1");
        Product product2 = new Product("test2", "test1", "test2","test", 11.20, "test1");
        Product product3 = new Product("test3", "test2", "test3","test", 11.20, "test1");
        Product product4 = new Product("test4", "test3", "test4","test",11.20, "test4");
        Product product5 = new Product("test5", "test4", "test5", "test",11.20, "test5");
        productService.add(product1);
        productService.add(product2);
        productService.add(product3);
        productService.add(product4);
        productService.add(product5);
        assertEquals(3, productService.getAllByType("test1").size());
        /*productService.remove(product1.getId());
        productService.remove(product2.getId());
        productService.remove(product3.getId());
        productService.remove(product4.getId());
        productService.remove(product5.getId());*/
        assertEquals(count, productService.getAll().size());
    }

}