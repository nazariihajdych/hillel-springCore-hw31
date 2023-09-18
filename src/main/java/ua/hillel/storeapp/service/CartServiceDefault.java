package ua.hillel.storeapp.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.hillel.storeapp.repo.CartInMemoryRepo;
import ua.hillel.storeapp.repo.ProductInMemoryRepo;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class CartServiceDefault implements CartService {

    private ProductInMemoryRepo productInMemoryRepo;
    private CartInMemoryRepo cartInMemoryRepo;
    @Override
    public void addProduct(Integer id) {
        cartInMemoryRepo.getAllProductsInCart().add(productInMemoryRepo.getProductById(id));

    }

    @Override
    public void removeProductById(Integer id) {
        cartInMemoryRepo.getAllProductsInCart().remove(productInMemoryRepo.getProductById(id));
    }

}
