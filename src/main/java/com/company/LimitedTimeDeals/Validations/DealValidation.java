package com.company.LimitedTimeDeals.Validations;

import com.company.LimitedTimeDeals.DTO.CreateDealRequest;
import com.company.LimitedTimeDeals.Model.Product;
import com.company.LimitedTimeDeals.Respository.DealRepository;
import com.company.LimitedTimeDeals.Respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DealValidation {
    ProductRepository productRepository;
    DealRepository dealRepository;

    public DealValidation(@Autowired ProductRepository productRepository, @Autowired DealRepository dealRepository){
        this.productRepository = productRepository;
        this.dealRepository = dealRepository;
    }
    public boolean isValidCreateDealRequest(CreateDealRequest createDealRequest){
        if(createDealRequest.getName().isEmpty()) {
            return false;
        }
        if(createDealRequest.getPrice() <= 0){
            return false;
        }
        Product product = this.productRepository.getProduct(createDealRequest.getProductId());
        if(product == null){
            return false;
        }
        return true;
    }
}
