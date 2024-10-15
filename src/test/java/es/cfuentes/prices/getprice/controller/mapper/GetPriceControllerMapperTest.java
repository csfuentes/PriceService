package es.cfuentes.prices.getprice.controller.mapper;

import es.cfuentes.prices.getprice.controller.model.GetPriceRequestDto;
import es.cfuentes.prices.getprice.controller.model.GetPriceResponseDto;
import es.cfuentes.prices.getprice.usecase.model.GetPriceRequest;
import es.cfuentes.prices.getprice.usecase.model.GetPriceResponse;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetPriceControllerMapperTest {
    private final GetPriceControllerMapper mapper = Mappers.getMapper(GetPriceControllerMapper.class);

    @Test
    void verifyMapToDomain() {
        GetPriceRequestDto getPriceRequestDto = Instancio.create(GetPriceRequestDto.class);

        GetPriceRequest actual = mapper.map(getPriceRequestDto);

        assertNotNull(actual);
        assertEquals(getPriceRequestDto.getProductId(), actual.getProductId());
        assertEquals(getPriceRequestDto.getBrandId(), actual.getBrandId());
        assertEquals(getPriceRequestDto.getApplicationDate(), actual.getApplicationDate());
    }

    @Test
    void verifyMapToResponseDto() {
        GetPriceResponse getPriceResponse = Instancio.create(GetPriceResponse.class);

        GetPriceResponseDto actual = mapper.map(getPriceResponse);

        assertNotNull(actual);
        assertEquals(getPriceResponse.getPrice(), actual.getPrice());
        assertEquals(getPriceResponse.getPriceList(), actual.getPriceList());
        assertEquals(getPriceResponse.getProductId(), actual.getProductId());
        assertEquals(getPriceResponse.getBrandId(), actual.getBrandId());
        assertEquals(getPriceResponse.getStartDate(), actual.getStartDate());
        assertEquals(getPriceResponse.getEndDate(), actual.getEndDate());
    }

}
