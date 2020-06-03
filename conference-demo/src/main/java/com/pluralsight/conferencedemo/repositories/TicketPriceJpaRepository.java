package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice, Long> {
}
