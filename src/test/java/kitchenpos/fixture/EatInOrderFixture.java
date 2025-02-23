package kitchenpos.fixture;

import kitchenpos.order.eatinorder.domain.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

import static kitchenpos.TestConstant.*;
import static kitchenpos.fixture.EatInOrderLineItemFixture.createOrderLineItem;

public class EatInOrderFixture {

    private EatInOrderFixture() {
    }

    public static EatInOrder createOrder(final UUID id, final EatInOrderType orderType, final EatInOrderStatus orderStatus, final LocalDateTime orderDateTime,
                                         final EatInOrderLineItem orderLineItem, final String deliveryAddress) {
        var order = new EatInOrder();
        order.setId(id);
        order.setType(orderType);
        order.setStatus(orderStatus);
        order.setOrderLineItems(Arrays.asList(orderLineItem));
        order.setOrderDateTime(orderDateTime);
        order.setDeliveryAddress(deliveryAddress);
        return order;
    }

    public static EatInOrder createOrder(final UUID id, final EatInOrderType orderType, final EatInOrderStatus orderStatus, final LocalDateTime orderDateTime,
                                         final EatInOrderLineItem orderLineItem, final String deliveryAddress, EatInOrderTable orderTable, UUID orderTableId) {
        var order = new EatInOrder();
        order.setId(id);
        order.setType(orderType);
        order.setStatus(orderStatus);
        order.setOrderLineItems(Arrays.asList(orderLineItem));
        order.setOrderDateTime(orderDateTime);
        order.setDeliveryAddress(deliveryAddress);
        order.setOrderTable(orderTable);
        order.setOrderTableId(orderTableId);
        return order;
    }

    public static EatInOrder createOrder(EatInOrderLineItem orderLineItem, String deliveryAddress) {
        return createOrder(ORDER_UUID, ORDER_TYPE_매장내식사주문, ORDER_STATUS_주문대기,null, orderLineItem, deliveryAddress);
      }

    public static EatInOrder createOrder(EatInOrderLineItem orderLineItem) {
        return createOrder(ORDER_UUID, ORDER_TYPE_매장내식사주문, ORDER_STATUS_주문대기, null,
                orderLineItem, "강남구");
    }

    public static EatInOrder createOrder(EatInOrderLineItem orderLineItem, EatInOrderStatus orderStatus) {
        return createOrder(ORDER_UUID, ORDER_TYPE_매장내식사주문, orderStatus, null,
                orderLineItem, "강남구");
    }

    public static EatInOrder createOrder(EatInOrderLineItem orderLineItem, EatInOrderType orderType, EatInOrderStatus orderStatus, EatInOrderTable orderTable) {
        return createOrder(ORDER_UUID, orderType, orderStatus, null,
                orderLineItem, "강남구", orderTable, orderTable.getId());
        }

    public static EatInOrder createOrder(EatInOrderLineItem orderLineItem, EatInOrderType orderType, EatInOrderStatus orderStatus) {
        return createOrder(ORDER_UUID, orderType, orderStatus, null,
                orderLineItem, "강남구");
    }

    public static EatInOrder createOrder() {
        return createOrder(ORDER_UUID, ORDER_TYPE_매장내식사주문, ORDER_STATUS_주문대기, ORDER_DATE_TIME_주문요청시간,
                createOrderLineItem(), "강남구");
    }

    public static EatInOrder createOrder(EatInOrderType orderType) {
        return createOrder(ORDER_UUID, orderType, ORDER_STATUS_주문대기, ORDER_DATE_TIME_주문요청시간,
                createOrderLineItem(), "강남구");
    }


    public static EatInOrder createOrder(EatInOrderStatus orderStatus, EatInOrderTable orderTable) {
        return createOrder(ORDER_UUID, ORDER_TYPE_매장내식사주문, orderStatus, ORDER_DATE_TIME_주문요청시간,
                createOrderLineItem(), "강남구", orderTable);
    }

    public static EatInOrder createOrder(UUID id, EatInOrderType orderType, EatInOrderStatus orderStatus, LocalDateTime orderDateTime, EatInOrderLineItem orderLineItem, String deliveryAddress, EatInOrderTable orderTable) {
        var order = new EatInOrder();
        order.setId(id);
        order.setType(orderType);
        order.setStatus(orderStatus);
        order.setOrderLineItems(Arrays.asList(orderLineItem));
        order.setOrderDateTime(orderDateTime);
        order.setDeliveryAddress(deliveryAddress);
        order.setOrderTable(orderTable);
        order.setOrderTableId(orderTable.getId());
        return order;
    }
}
