package com.company.LimitedTimeDeals.Service;

import com.company.LimitedTimeDeals.DTO.CreateDealRequest;
import com.company.LimitedTimeDeals.Exception.InvalidInputException;
import com.company.LimitedTimeDeals.Model.Deal;
import com.company.LimitedTimeDeals.Model.Product;
import com.company.LimitedTimeDeals.Respository.DealRepository;
import com.company.LimitedTimeDeals.Respository.ProductRepository;
import com.company.LimitedTimeDeals.Validations.DealValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealService {
    final ProductRepository productRepository;
    final DealRepository DealRepository;
    final DealValidation DealValidation;
    public DealService(@Autowired ProductRepository productRepository, @Autowired DealRepository dealRepository, @Autowired DealValidation dealValidation){
        this.productRepository = productRepository;
        this.DealRepository = dealRepository;
        this.DealValidation = dealValidation;
    }

    public Deal createDeal(final CreateDealRequest createDealRequest) throws InvalidInputException {
        if(this.DealValidation.isValidCreateDealRequest(createDealRequest)){
            throw new InvalidInputException("Bad Request");
        }
        Product product = this.productRepository.getProduct(createDealRequest.getProductId());
        final Deal newDeal = Deal.getDealFromRequest(createDealRequest, product);
        return this.DealRepository.createDeal(newDeal);
    }

    public Deal getDeal(final String DealId) {
        return this.DealRepository.getDeal(DealId);
    }
}
