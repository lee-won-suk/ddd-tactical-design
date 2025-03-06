package kitchenpos.product.adapter.in.web.mapper;

import kitchenpos.product.adapter.in.web.request.ProductRequestDto;
import kitchenpos.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapProduct(ProductRequestDto productRequestDto) {
        return new Product(productRequestDto.id(), productRequestDto.name(), productRequestDto.price());
    }
}
