package es.cfuentes.prices.getprice.controller.mapper;

import es.cfuentes.prices.getprice.controller.model.GetPriceRequestDto;
import es.cfuentes.prices.getprice.controller.model.GetPriceResponseDto;
import es.cfuentes.prices.getprice.usecase.model.GetPriceRequest;
import es.cfuentes.prices.getprice.usecase.model.GetPriceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetPriceControllerMapper {

    GetPriceRequest map(GetPriceRequestDto requestDTO);

    GetPriceResponseDto map(GetPriceResponse getPriceResponse);

}