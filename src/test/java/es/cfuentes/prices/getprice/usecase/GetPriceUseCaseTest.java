package es.cfuentes.prices.getprice.usecase;

import es.cfuentes.prices.common.entities.Price;
import es.cfuentes.prices.common.repositories.price.PriceRepository;
import es.cfuentes.prices.getprice.usecase.mapper.GetPriceUseCaseMapper;
import es.cfuentes.prices.getprice.usecase.model.GetPriceRequest;
import es.cfuentes.prices.getprice.usecase.model.GetPriceResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetPriceUseCaseTest {

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private GetPriceUseCaseMapper getPriceUseCaseMapper;

    @InjectMocks
    private GetPriceUseCase getPriceUsecase;

    @Test
    public void testGetPriceUseCaseReturns3550When10Day14For35455() {
        Price price = Price.builder()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .productId(35455L)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))  // Usar BigDecimal
                .currency("EUR")
                .build();

        when(priceRepository.findApplicablePriceOrderedByPriority(
                1L, 35455L, LocalDateTime.of(2020, 6, 14, 10, 0)))
                .thenReturn(List.of(price));

        GetPriceResponse getPriceResponse = GetPriceResponse.builder()
                .brandId(1L)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .productId(35455L)
                .price(BigDecimal.valueOf(35.50))
                .priceList(1L)
                .build();

        when(getPriceUseCaseMapper.map(price)).thenReturn(getPriceResponse);

        GetPriceRequest priceToGet = GetPriceRequest.builder()
                .applicationDate(LocalDateTime.of(2020, 6, 14, 10, 0, 0))
                .productId(35455L)
                .brandId(1L)
                .build();

        GetPriceResponse result = getPriceUsecase.getPrice(priceToGet);

        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(35.50), result.getPrice());
    }
}
