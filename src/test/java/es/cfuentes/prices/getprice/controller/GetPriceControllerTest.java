package es.cfuentes.prices.getprice.controller;

import es.cfuentes.prices.getprice.controller.impl.GetPriceControllerImpl;
import es.cfuentes.prices.getprice.controller.mapper.GetPriceControllerMapper;
import es.cfuentes.prices.getprice.controller.model.GetPriceResponseDto;
import es.cfuentes.prices.getprice.usecase.GetPriceUseCase;
import es.cfuentes.prices.getprice.usecase.model.GetPriceResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetPriceControllerTest {

    @Mock
    private GetPriceUseCase getPriceUsecase;

    @Mock
    private GetPriceControllerMapper getPriceControllerMapper;

    @InjectMocks
    private GetPriceControllerImpl getPriceController;

    @Test
    public void testGetPriceControllerReturns3550When10Day14For35455() {

        GetPriceResponse getPriceResponse = GetPriceResponse.builder()
                .brandId(1L)
                .productId(35455L)
                .priceList(1L)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .price(BigDecimal.valueOf(35.50))
                .build();

        GetPriceResponseDto getPriceResponseDTO = GetPriceResponseDto.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(1L)
                .price(BigDecimal.valueOf(35.50))
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .build();

        when(getPriceUsecase.getPrice(any())).thenReturn(getPriceResponse);
        when(getPriceControllerMapper.map(getPriceResponse)).thenReturn(getPriceResponseDTO);

        ResponseEntity<GetPriceResponseDto> response = getPriceController.getPrice(1L, 35455L, LocalDateTime.of(2020, 6, 14, 10, 0));

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(BigDecimal.valueOf(35.50), response.getBody().getPrice());
    }
}
