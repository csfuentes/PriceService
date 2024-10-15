package es.cfuentes.prices.common.repositories.price;

import es.cfuentes.prices.common.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId AND :applicationDate BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
    List<Price> findApplicablePriceOrderedByPriority(Long brandId, Long productId, LocalDateTime applicationDate);

}
