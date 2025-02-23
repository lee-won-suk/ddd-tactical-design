package kitchenpos.fixture;


import kitchenpos.order.eatinorder.domain.EatInOrderTable;

import java.util.UUID;

public class EatInOrderTableFixture {

    private EatInOrderTableFixture() {
    }

    public static EatInOrderTable createOrderTable() {
        return createOrderTable(UUID.randomUUID(), "1번", 1, true);
        }

    public static EatInOrderTable createOrderTable(UUID orderTableId, String orderTableName, int numberOfGuest, boolean istableUsable) {
        var orderTable = new EatInOrderTable();
        orderTable.setId(orderTableId);
        orderTable.setName(orderTableName);
        orderTable.setNumberOfGuests(numberOfGuest);
        orderTable.setOccupied(istableUsable);
        return orderTable;
    }

    public static EatInOrderTable createOrderTable(String name) {
        return createOrderTable(name,1);
    }

    public static EatInOrderTable createOrderTable(String name, int numberOfGuests) {
        return createOrderTable(UUID.randomUUID(), name, numberOfGuests, true);
        }

    public static EatInOrderTable createOrderTable(String name, boolean isOcupied) {
        var orderTable = new EatInOrderTable();
        orderTable.setId(UUID.randomUUID());
        orderTable.setName(name);
        orderTable.setNumberOfGuests(1);
        orderTable.setOccupied(isOcupied);
        return orderTable;
    }
}
