package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pricing_categories")
public class PricingCategory {
    @Id
    @Column(name = "pricing_category_code")
    private String pricingCategoryCode;

    @Column(name = "pricing_category_name")
    private String pricingCategoryName;

    @Column(name = "pricing_start_date")
    private Date pricingStartDate;

    @Column(name = "pricing_end_date")
    private Date pricingEndDate;

    @OneToMany(mappedBy = "ticketType")
    @JsonIgnore
    private List<TicketPrice> ticketPrices;

    public PricingCategory() {
    }

    public String getPricingCategoryCode() {
        return pricingCategoryCode;
    }

    public void setPricingCategoryCode(String pricingCategoryCode) {
        this.pricingCategoryCode = pricingCategoryCode;
    }

    public String getPricingCategoryName() {
        return pricingCategoryName;
    }

    public void setPricingCategoryName(String pricingCategoryName) {
        this.pricingCategoryName = pricingCategoryName;
    }

    public Date getPricingStartDate() {
        return pricingStartDate;
    }

    public void setPricingStartDate(Date pricingStartDate) {
        this.pricingStartDate = pricingStartDate;
    }

    public Date getPricingEndDate() {
        return pricingEndDate;
    }

    public void setPricingEndDate(Date pricingEndDate) {
        this.pricingEndDate = pricingEndDate;
    }

    public List<TicketPrice> getTicketPrices() {
        return ticketPrices;
    }

    public void setTicketPrices(List<TicketPrice> ticketPrices) {
        this.ticketPrices = ticketPrices;
    }
}
