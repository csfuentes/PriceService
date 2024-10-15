package es.cfuentes.prices.getprice.usecase.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetPriceRequest {
    private Long brandId;
    private Long productId;
    private LocalDateTime applicationDate;
}