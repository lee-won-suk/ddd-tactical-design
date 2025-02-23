package kitchenpos.order.eatinorder.adapter.out.persistance;

import kitchenpos.order.eatinorder.application.port.out.EatInOrderTableRepository;
import kitchenpos.order.eatinorder.domain.EatInOrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaOrderTableRepository extends EatInOrderTableRepository, JpaRepository<EatInOrderTable, UUID> {
}
