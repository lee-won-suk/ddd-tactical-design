package kitchenpos.order.deliveryorder.adapter.out.persistance;

import kitchenpos.order.deliveryorder.application.port.out.DeliveryOrderRepository;
import kitchenpos.order.deliveryorder.domain.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaDeliveryOrderRepository extends DeliveryOrderRepository, JpaRepository<DeliveryOrder, UUID> {
}
