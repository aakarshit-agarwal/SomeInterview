package com.company.LimitedTimeDeals.Service;

import com.company.LimitedTimeDeals.DTO.CreateProductRequest;
import com.company.LimitedTimeDeals.Exception.InvalidInputException;
import com.company.LimitedTimeDeals.Model.Product;
import com.company.LimitedTimeDeals.Respository.ProductRepository;
import com.company.LimitedTimeDeals.Validations.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    final ProductRepository productRepository;
    final ProductValidation productValidation;
    public ProductService(@Autowired ProductRepository productRepository, @Autowired ProductValidation productValidation){
        this.productRepository = productRepository;
        this.productValidation = productValidation;
    }

    public Product createProduct(final CreateProductRequest createProductRequest) throws InvalidInputException {
        if(this.productValidation.isValidCreateProductRequest(createProductRequest)){
            throw new InvalidInputException("Bad Request");
        }
        final Product newProduct = Product.getProductFromRequest(createProductRequest);
        return this.productRepository.createProduct(newProduct);
    }

    public Product getProduct(final String productId) {
        return this.productRepository.getProduct(productId);
    }
}
