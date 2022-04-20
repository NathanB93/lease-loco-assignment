package com.leaseloco.leaselocoassignment.batchprocessing;

import com.leaseloco.leaselocoassignment.POJOs.DealPOJO;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class CustomFieldSetMapper implements FieldSetMapper {
    @Override
    public Object mapFieldSet(FieldSet fieldSet) throws BindException {
        DealPOJO deal = new DealPOJO();

        //determines which datasource is being read (data.csv or pricing.csv)
        if (fieldSet.getFieldCount() == 7) {

            deal.setId(fieldSet.readString(0));
            deal.setMake(fieldSet.readString(1));
            deal.setModel(fieldSet.readString(2));
            deal.setDescription(fieldSet.readString(3));
            deal.setMileage(fieldSet.readString(4));
            deal.setPrice(fieldSet.readString(5));
            deal.setTerm(fieldSet.readString(6));
            deal.setWebsite("prettygoodcardeals.com");

        }else {
            deal.setId(fieldSet.readString(0));
            deal.setMake(fieldSet.readString(1));
            deal.setModel(fieldSet.readString(2));
            deal.setDescription(null);
            deal.setMileage(fieldSet.readString(5));
            deal.setPrice(fieldSet.readString(3));
            deal.setTerm(fieldSet.readString(4));
            deal.setWebsite("amazingcars.co.uk");
        }
        return deal;
    }
}




