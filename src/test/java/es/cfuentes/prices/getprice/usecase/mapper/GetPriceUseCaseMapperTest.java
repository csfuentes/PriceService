package es.cfuentes.prices.getprice.usecase.mapper;

import es.cfuentes.prices.common.entities.Price;
import es.cfuentes.prices.getprice.usecase.model.GetPriceResponse;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetPriceUseCaseMapperTest {
    private final GetPriceUseCaseMapper mapper = Mappers.getMapper(GetPriceUseCaseMapper.class);

    @Test
    void verifyMapToDomain() {
        Price price = Instancio.create(Price.class);

        GetPriceResponse actual = mapper.map(price);

        assertNotNull(actual);
        assertEquals(price.getProductId(), actual.getProductId());
        assertEquals(price.getBrandId(), actual.getBrandId());
        assertEquals(price.getStartDate(), actual.getStartDate());
        assertEquals(price.getEndDate(), actual.getEndDate());
        assertEquals(price.getPrice(), actual.getPrice());
        assertEquals(price.getPriceList(), actual.getPriceList());
    }
}
