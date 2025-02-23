package kitchenpos.application;



import kitchenpos.order.eatinorder.application.port.out.EatInOrderTableRepository;
import kitchenpos.order.eatinorder.domain.EatInOrderTable;

import java.util.*;

public class InMemoryOrderTableRepository implements EatInOrderTableRepository {
    private final Map<UUID, EatInOrderTable> orderTables = new HashMap<>();

    @Override
    public Optional<EatInOrderTable> findById(UUID orderTableId) {
        return Optional.ofNullable(orderTables.get(orderTableId));
    }

    @Override
    public EatInOrderTable save(EatInOrderTable orderTable) {
        orderTables.put(orderTable.getId(), orderTable);
        return orderTable;
    }

    @Override
    public List<EatInOrderTable> findAll() {
        return new ArrayList<>(orderTables.values());
    }
}
