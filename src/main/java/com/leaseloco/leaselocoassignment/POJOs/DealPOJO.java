package com.leaseloco.leaselocoassignment.POJOs;

public class DealPOJO {

    private String id = null;

    private String make = null;

    private String model = null;

    private String description = null;

    private String mileage = null;

    private String price = null;

    private String term = null;

    private String website = null;

    public DealPOJO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    public String toString(){
        return id + " " + make + " " + model + " " + description + " " + mileage + " " + price + " " + term ;
    }
}
