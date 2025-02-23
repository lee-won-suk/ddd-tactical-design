package kitchenpos.order.takeoutorder.application.port.out;

import kitchenpos.order.takeoutorder.domain.TakeOutOrder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TakeOutOrderRepository {
    TakeOutOrder save(TakeOutOrder order);

    Optional<TakeOutOrder> findById(UUID id);

    List<TakeOutOrder> findAll();

}

