package com.leaseloco.leaselocoassignment.controllers;

import com.leaseloco.leaselocoassignment.POJOs.DealPOJO;
import com.leaseloco.leaselocoassignment.models.Deal;
import com.leaseloco.leaselocoassignment.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DealController {


    @Autowired
    DealService dealService;


    @GetMapping("/deals")
    public ResponseEntity<List<Deal>> getDeals(@Valid DealPOJO searchCriteria) {

        try {
            List<Deal> deals = new ArrayList<>();

            deals.addAll(dealService.findDeals(searchCriteria));

            if (deals.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(deals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}


