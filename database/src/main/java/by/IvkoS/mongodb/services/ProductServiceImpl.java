package by.IvkoS.mongodb.services;

import by.IvkoS.mongodb.dao.ProductDao;
import by.IvkoS.mongodb.dao.SequenceDao;
import by.IvkoS.mongodb.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    SequenceDao sequenceDao;

    @Override
    public void add(Product product) {
        product.setId(sequenceDao.getNextSequenceId(Product.COLLECTION_NAME));
        productDao.save(product);
    }

    @Override
    public void update(Product product) {
        productDao.save(product);
    }

    @Override
    public Product get(Long id) {
        return productDao.get(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void remove(Long id) {
        productDao.remove(id);
    }

    @Override
    public List<Product> getAllByType(String type) {
        return productDao.getAllByType(type);
    }
}
