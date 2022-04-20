package com.leaseloco.leaselocoassignment.services;

import com.leaseloco.leaselocoassignment.POJOs.DealPOJO;
import com.leaseloco.leaselocoassignment.models.Deal;
import com.leaseloco.leaselocoassignment.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    DealRepository dealRepository;

    public List<Deal> findDeals(DealPOJO searchCriteria){

        Deal deal = new Deal();

        deal.setDeal_id(searchCriteria.getId());
        deal.setMake(searchCriteria.getMake());
        deal.setModel(searchCriteria.getModel());
        if(searchCriteria.getMileage() != null){
            deal.setMileage(Integer.valueOf(searchCriteria.getMileage()));
        }
        if(searchCriteria.getPrice() != null){
            deal.setPrice(new BigDecimal(searchCriteria.getPrice()));
        }
        if(searchCriteria.getTerm() != null){
            deal.setTerm(Short.valueOf(searchCriteria.getTerm()));
        }
        deal.setDescription(searchCriteria.getDescription());
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<Deal> example = Example.of(deal, matcher);

        return dealRepository.findAll(example);
    }
}
