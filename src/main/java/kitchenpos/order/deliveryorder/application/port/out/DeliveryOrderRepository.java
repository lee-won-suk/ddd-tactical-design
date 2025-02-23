package kitchenpos.order.deliveryorder.application.port.out;

import kitchenpos.order.deliveryorder.domain.DeliveryOrder;
import kitchenpos.order.deliveryorder.domain.DeliveryOrderStatus;
import kitchenpos.order.eatinorder.domain.EatInOrderTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryOrderRepository {
    DeliveryOrder save(DeliveryOrder order);

    Optional<DeliveryOrder> findById(UUID id);

    List<DeliveryOrder> findAll();
}

