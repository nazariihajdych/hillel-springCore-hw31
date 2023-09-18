package ua.hillel.storeapp.repo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ua.hillel.storeapp.model.Product;

import java.util.List;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor
public class CartInMemoryRepo implements CartRepo{

    private List<Product> productsInCart;
    @Override
    public List<Product> getAllProductsInCart() {
        return productsInCart;
    }
}
