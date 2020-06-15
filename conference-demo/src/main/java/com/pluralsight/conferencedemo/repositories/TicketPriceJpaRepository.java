package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice, Long> {
    @Query("select tp from TicketPrice tp where tp.basePrice < ?1 " +
            "and tp.ticketType.includesWorkshop = true")
    List<TicketPrice> getTicketsUnderPriceWithWorkshops(BigDecimal maxPrice);

    List<TicketPrice> namedFindTicketsByPricingCategoryName(@Param("name") String name);

    List<TicketPrice> nativeFindTicketsByCategoryWithWorkshop(@Param("name") String name);
}
