package com.leaseloco.leaselocoassignment.batchprocessing;

import com.leaseloco.leaselocoassignment.POJOs.DealPOJO;
import com.leaseloco.leaselocoassignment.models.Deal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

public class DealItemProcessor implements ItemProcessor<DealPOJO, Deal> {
    private static final Logger log = LoggerFactory.getLogger(DealItemProcessor.class);

    @Override
    public Deal process(final DealPOJO deal) throws Exception {
        final String id = deal.getId().toUpperCase();
        final String make = deal.getMake().toUpperCase();
        final String model = deal.getModel().toUpperCase();
        final String description = make + " " + model;
        final Integer mileage = convertToInteger(deal.getMileage(), "k", "000");
        final BigDecimal price = new BigDecimal(deal.getPrice().replace("£", ""));
        final Short term = Short.valueOf(deal.getTerm());
        final String website = deal.getWebsite();
        final Deal transformedDeal = new Deal(id, make, model, description, mileage, price, term, website);


        log.info("Converting (" + deal + ") into (" + transformedDeal + ")");

        return transformedDeal;

    }
    public Integer convertToInteger(String s, String target, String replacement){

        s = s.replace(target, replacement);

        return Integer.valueOf(s);
    }
}

