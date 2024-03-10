package com.company.LimitedTimeDeals.Validations;

import com.company.LimitedTimeDeals.DTO.CreateProductRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductValidation {
    public boolean isValidCreateProductRequest(CreateProductRequest createProductRequest){
        if(createProductRequest.getName().isEmpty()) {
            return false;
        }
        if(createProductRequest.getPrice() <= 0){
            return false;
        }
        return true;
    }
}
