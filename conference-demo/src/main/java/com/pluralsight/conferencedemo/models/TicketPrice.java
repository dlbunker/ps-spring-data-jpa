package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity(name = "ticket_prices")
public class TicketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_price_id")
    private Long ticketPriceId;

    @Column(name = "base_price")
    private String basePrice;

    @ManyToOne
    @JoinColumn(name = "ticket_type_code", nullable = false, updatable = false)
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "pricing_category_code", nullable = false, updatable = false)
    private PricingCategory pricingCategory;

    public TicketPrice() {
    }

    public Long getTicketPriceId() {
        return ticketPriceId;
    }

    public void setTicketPriceId(Long ticketPriceId) {
        this.ticketPriceId = ticketPriceId;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public PricingCategory getPricingCategory() {
        return pricingCategory;
    }

    public void setPricingCategory(PricingCategory pricingCategory) {
        this.pricingCategory = pricingCategory;
    }
}
