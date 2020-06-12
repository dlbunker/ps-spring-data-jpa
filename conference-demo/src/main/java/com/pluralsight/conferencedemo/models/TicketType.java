package com.pluralsight.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket_types")
public class TicketType {
    @Id
    @Column(name = "ticket_type_code")
    private String ticketTypeCode;

    @Column(name = "ticket_type_name")
    private String ticketTypeName;

    @Column(name = "description")
    private String description;

    @Column(name = "includes_workshop")
    private Boolean includesWorkshop;

    @OneToMany(mappedBy = "ticketType")
    @JsonIgnore
    private List<TicketPrice> ticketPrices;

    public TicketType() {
    }

    public String getTicketTypeCode() {
        return ticketTypeCode;
    }

    public void setTicketTypeCode(String ticketTypeCode) {
        this.ticketTypeCode = ticketTypeCode;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIncludesWorkshop() {
        return includesWorkshop;
    }

    public void setIncludesWorkshop(Boolean includesWorkshop) {
        this.includesWorkshop = includesWorkshop;
    }

    public List<TicketPrice> getTicketPrices() {
        return ticketPrices;
    }

    public void setTicketPrices(List<TicketPrice> ticketPrices) {
        this.ticketPrices = ticketPrices;
    }
}
