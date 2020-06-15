package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ticket_prices")
@NamedQuery(
        name = "TicketPrice.namedFindTicketsByPricingCategoryName",
        query = "select tp from TicketPrice tp where tp.pricingCategory.pricingCategoryName = :name"
)
@NamedNativeQuery(
        name = "TicketPrice.nativeFindTicketsByCategoryWithWorkshop",
        query = "select tp.* from ticket_prices tp " +
                "left join ticket_types tt on tp.ticket_type_code = tt.ticket_type_code " +
                "left join pricing_categories pc on tp.pricing_category_code = pc.pricing_category_code " +
                "where tt.includes_workshop = true and pc.pricing_category_name = :name",
        resultClass = TicketPrice.class
)
public class TicketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_price_id")
    private Long ticketPriceId;

    @Column(name = "base_price")
    private BigDecimal basePrice;

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

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
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
