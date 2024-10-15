package es.cfuentes.prices.getprice.usecase.mapper;

import es.cfuentes.prices.common.entities.Price;
import es.cfuentes.prices.getprice.usecase.model.GetPriceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetPriceUseCaseMapper {

    GetPriceResponse map(Price price);
}
