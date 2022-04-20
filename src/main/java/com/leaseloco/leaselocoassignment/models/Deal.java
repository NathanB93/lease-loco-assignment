package com.leaseloco.leaselocoassignment.models;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "deals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "deal_id", length = 16)
    private String deal_id;

    @Column(name = "make", length = 8)
    private String make;

    @Column(name = "model", length =6)
    private String model;

    @Column(name = "description",length=16)
    private String description;

    @Column(name="mileage", length=9)
    private Integer mileage;

    @Column(name="price_£", precision = 6, scale = 2)
    private BigDecimal price;

    @Column(name="term")
    private Short term;

    @Column(name= "website", length = 24)
    private String website;

    public Deal() {
    }

    public Deal(String deal_id, String make, String model, String description,
                Integer mileage, BigDecimal price, Short term, String website) {

        this.deal_id = deal_id;
        this.make = make;
        this.model = model;
        this.description = description;
        this.mileage = mileage;
        this.price = price;
        this.term = term;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(String deal_id) {
        this.deal_id = deal_id;
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

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getTerm() {
        return term;
    }

    public void setTerm(Short term) {
        this.term = term;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
