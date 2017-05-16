package by.IvkoS.mongodb.dao;

import by.IvkoS.mongodb.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Product product) {
        mongoOperations.save(product);

    }

    public Product get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Product.class);
    }

    public List<Product> getAll() {
        return mongoOperations.findAll(Product.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Product.class);
    }

    @Override
    public List<Product> getAllByType(String type) {
        return mongoOperations.find(Query.query(Criteria.where("type").is(type)),Product.class);
    }
}
