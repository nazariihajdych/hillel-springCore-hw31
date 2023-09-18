package ua.hillel.storeapp.repo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.hillel.storeapp.model.Product;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductInMemoryRepo implements ProductRepo {
    private List<Product> productList;

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product getProductById(Integer id) {
        return productList.stream().
                filter(p -> p.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Can't find product with id = " + id));
    }

    @Override
    public void addProductInRepo(Product product) {
        productList.add(product);
    }
}
