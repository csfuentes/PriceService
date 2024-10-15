package es.cfuentes.prices.getprice.usecase;

import es.cfuentes.prices.common.entities.Price;
import es.cfuentes.prices.common.exception.PriceNotFoundException;
import es.cfuentes.prices.common.repositories.price.PriceRepository;
import es.cfuentes.prices.getprice.usecase.mapper.GetPriceUseCaseMapper;
import es.cfuentes.prices.getprice.usecase.model.GetPriceRequest;
import es.cfuentes.prices.getprice.usecase.model.GetPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPriceUseCase {

    private final PriceRepository priceRepository;
    private final GetPriceUseCaseMapper getPriceUseCaseMapper;

    public GetPriceResponse getPrice(GetPriceRequest getPriceRequest) {

        Price price = priceRepository
                .findApplicablePriceOrderedByPriority(
                        getPriceRequest.getBrandId(),
                        getPriceRequest.getProductId(),
                        getPriceRequest.getApplicationDate()
                ).stream().findFirst()
                .orElseThrow(() -> new PriceNotFoundException("No hay precio para ese producto en la fecha indicada"));

        return getPriceUseCaseMapper.map(price);
    }
}
