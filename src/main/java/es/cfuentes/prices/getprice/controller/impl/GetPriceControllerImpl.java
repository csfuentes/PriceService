package es.cfuentes.prices.getprice.controller.impl;

import es.cfuentes.prices.getprice.controller.GetPriceController;
import es.cfuentes.prices.getprice.controller.mapper.GetPriceControllerMapper;
import es.cfuentes.prices.getprice.controller.model.GetPriceRequestDto;
import es.cfuentes.prices.getprice.controller.model.GetPriceResponseDto;
import es.cfuentes.prices.getprice.usecase.GetPriceUseCase;
import es.cfuentes.prices.getprice.usecase.model.GetPriceRequest;
import es.cfuentes.prices.getprice.usecase.model.GetPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class GetPriceControllerImpl implements GetPriceController {

    private final GetPriceUseCase getPriceUsecase;
    private final GetPriceControllerMapper getPriceControllerMapper;

    @Override
    @GetMapping
    public ResponseEntity<GetPriceResponseDto> getPrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam LocalDateTime applicationDate) {

        GetPriceRequestDto getPriceRequestDTO = GetPriceRequestDto.builder()
                .brandId(brandId)
                .productId(productId)
                .applicationDate(applicationDate)
                .build();

        GetPriceRequest getPriceRequest = getPriceControllerMapper.map(getPriceRequestDTO);
        GetPriceResponse getPriceResponse = getPriceUsecase.getPrice(getPriceRequest);
        GetPriceResponseDto getPriceResponseDTO = getPriceControllerMapper.map(getPriceResponse);

        return ResponseEntity.ok(getPriceResponseDTO);
    }
}
