package es.cfuentes.prices.getprice.controller;


import es.cfuentes.prices.getprice.controller.model.GetPriceResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface GetPriceController {

    @Operation(summary = "Get price for a product",
            description = "Get the applicable price for a product at a specific date and brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Price not found")
    })
    ResponseEntity<GetPriceResponseDto> getPrice(Long brandId, Long productId, LocalDateTime applicationDate);
}