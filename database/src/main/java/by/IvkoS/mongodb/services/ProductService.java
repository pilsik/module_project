package by.IvkoS.mongodb.services;

import by.IvkoS.mongodb.models.Product;

import java.util.List;

public interface ProductService {

    void add(Product product);

    void update(Product product);

    Product get(Long id);

    List<Product> getAll();

    void remove(Long id);

    List<Product> getAllByType(String type);
}
