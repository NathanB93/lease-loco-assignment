package com.leaseloco.leaselocoassignment.services;

import com.leaseloco.leaselocoassignment.POJOs.DealPOJO;
import com.leaseloco.leaselocoassignment.models.Deal;

import java.util.List;

public interface DealService {


    List<Deal> findDeals(DealPOJO deal);


}
