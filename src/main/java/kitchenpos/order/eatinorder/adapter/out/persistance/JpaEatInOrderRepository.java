package kitchenpos.order.eatinorder.adapter.out.persistance;

import kitchenpos.order.eatinorder.application.port.out.EatInOrderRepository;
import kitchenpos.order.eatinorder.domain.EatInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaEatInOrderRepository extends EatInOrderRepository, JpaRepository<EatInOrder, UUID> {
}
