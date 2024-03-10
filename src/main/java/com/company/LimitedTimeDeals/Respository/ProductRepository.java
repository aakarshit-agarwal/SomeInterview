package com.company.LimitedTimeDeals.Respository;

import com.company.LimitedTimeDeals.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {

    HashMap<String, Product> productIdToObjectMapping;
    public ProductRepository(){
        this.productIdToObjectMapping = new HashMap<>();
    }

    public Product createProduct(final Product product){
        this.productIdToObjectMapping.put(product.getId(), product);
        return this.productIdToObjectMapping.get(product.getId());
    }

    public Product getProduct(final String productId) {
        return this.productIdToObjectMapping.get(productId);
    }

//    public Product updateProduct(final Product product) {
//        this.productIdToObjectMapping
//    }

    public Product deleteProduct(final String productId) {
        final Product product = this.getProduct(productId);
        this.productIdToObjectMapping.remove(productId);
        return product;
    }
}
