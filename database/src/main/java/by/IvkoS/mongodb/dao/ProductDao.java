package by.IvkoS.mongodb.dao;

import by.IvkoS.mongodb.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    void save(Product product);

    Product get(Long id);

    List<Product> getAll();

    void remove(Long id);

    List<Product> getAllByType(String type);
}
