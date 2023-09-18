package ua.hillel.storeapp.repo;

import ua.hillel.storeapp.model.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    void addProductInRepo(Product product);
}
