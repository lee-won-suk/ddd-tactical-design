package kitchenpos.order.takeoutorder.adapter.out.persistance;

import kitchenpos.order.takeoutorder.application.port.out.TakeOutOrderRepository;
import kitchenpos.order.takeoutorder.domain.TakeOutOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTakeOutOrderRepository extends TakeOutOrderRepository, JpaRepository<TakeOutOrder, UUID> {
}
