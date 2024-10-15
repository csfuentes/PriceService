package es.cfuentes.prices.getprice.controller.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetPriceRequestDto {
    private Long brandId;
    private Long productId;
    private LocalDateTime applicationDate;
}