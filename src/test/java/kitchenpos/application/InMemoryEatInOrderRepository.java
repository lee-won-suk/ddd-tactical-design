package kitchenpos.application;



import kitchenpos.order.eatinorder.application.port.out.EatInOrderRepository;
import kitchenpos.order.eatinorder.domain.EatInOrder;
import kitchenpos.order.eatinorder.domain.EatInOrderStatus;
import kitchenpos.order.eatinorder.domain.EatInOrderTable;

import java.util.*;

public class InMemoryEatInOrderRepository implements EatInOrderRepository {
    private final Map<UUID, EatInOrder> orders = new HashMap<>();

    @Override
    public EatInOrder save(EatInOrder order) {
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<EatInOrder> findById(UUID orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }

    @Override
    public boolean existsByEatInOrderTableAndStatusNot(EatInOrderTable eatInOrderTable, EatInOrderStatus status) {
        return orders.values().stream()
                .anyMatch(order -> order.getOrderTable().equals(eatInOrderTable) && order.getStatus() != status);
    }

    @Override
    public List<EatInOrder> findAll() {
        return new ArrayList<>(orders.values());
    }


}
