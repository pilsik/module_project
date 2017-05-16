package by.IvkoS.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection= Product.COLLECTION_NAME)
public class Product implements Serializable{

    public static final String COLLECTION_NAME = "products";

    @Id
    private Long id;

    private String name;
    private String description;
    private String producer;
    private String imgPath;
    private double price;
    private String type;

    public Product() {
    }

    public Product(String name, String description, String producer, String imgPath, double price, String type) {

        this.name = name;
        this.description = description;
        this.producer = producer;
        this.imgPath = imgPath;
        this.price = price;
        this.type = type;
    }

    public Product(Long id, String name, String description, String producer, String imgPath, double price, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.producer = producer;
        this.imgPath = imgPath;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", producer='" + producer + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return producer != null ? producer.equals(product.producer) : product.producer == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }


}
