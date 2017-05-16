package by.IvkoS.rest.controllers;

import by.IvkoS.mongodb.models.Product;
import by.IvkoS.mongodb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/rest")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody
    List<Product> getAllProduct() {
        return this.productService.getAll();
    }

    @RequestMapping(value = "/products/{type}", method = RequestMethod.GET)
    public @ResponseBody List<Product> getAllProductByType(@PathVariable String type) {
        return this.productService.getAllByType(type);
    }

    @RequestMapping(value = "/products/id/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Product getProductById(@PathVariable Long id) {
        return this.productService.get(id);
    }

    @RequestMapping(value = "/products/id/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductById(@PathVariable Long id) {
        this.productService.remove(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody Product product) {
        productService.update(product);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody final Product product) {
        productService.add(product);
    }


}
