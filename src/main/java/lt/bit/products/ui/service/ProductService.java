package lt.bit.products.ui.service;

import lt.bit.products.ui.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {

        products.add(new Product("Product1", BigDecimal.valueOf(10.50), 5, "One  product "));
        products.add(new Product("Product2", BigDecimal.valueOf(12.35), 11, "Two products"));
        products.add(new Product("Product3", BigDecimal.valueOf(9.87), 27, "Third product"));
        products.add(new Product("Product4", BigDecimal.valueOf(3.99), 55, "Fourth product"));
        products.add(new Product("Product5", BigDecimal.valueOf(59.78), 3, "Fifth Product"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void saveProduct(Product product) {

        Product existingProduct = findProduct(product.getId());
        if (existingProduct == null) {
            products.add(product);
        } else {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setDescription(product.getDescription());
        }

    }

    public void deleteProduct(UUID id) {
        products.remove(findProduct(id));
    }

    public Product getProduct(UUID id) {
        return findProduct(id);
    }

    private Product findProduct(UUID id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
