package ua.hillel.storeapp.repo;

import ua.hillel.storeapp.model.Product;

import java.util.List;

public interface CartRepo {
    List<Product> getAllProductsInCart();
}
