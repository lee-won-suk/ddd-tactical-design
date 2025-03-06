package kitchenpos.product.adapter.in.web.request;

import java.math.BigDecimal;
import java.util.UUID;


public record ProductRequestDto(UUID id,
                                String name,
                                BigDecimal price
) {

}
