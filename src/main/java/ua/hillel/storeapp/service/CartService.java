package ua.hillel.storeapp.service;

public interface CartService {
    void addProduct(Integer id);
    void removeProductById(Integer id);
}
