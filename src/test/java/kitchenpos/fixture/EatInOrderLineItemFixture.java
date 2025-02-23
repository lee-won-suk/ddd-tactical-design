package kitchenpos.fixture;



import kitchenpos.menu.domain.Menu;
import kitchenpos.order.eatinorder.domain.EatInOrderLineItem;

import java.math.BigDecimal;
import java.util.UUID;

import static kitchenpos.TestConstant.*;

public class EatInOrderLineItemFixture {

    private EatInOrderLineItemFixture() {
    }

    public static EatInOrderLineItem createOrderLineItem(UUID menuId, long quantity, BigDecimal price) {
        var orderLineItem = new EatInOrderLineItem();
        orderLineItem.setQuantity(quantity);
        orderLineItem.setMenuId(menuId);
        orderLineItem.setPrice(price);
        return orderLineItem;
    }

    public static EatInOrderLineItem createOrderLineItem() {
        return createOrderLineItem(후라이드치킨_MENU_UUID, DEFAULT_QUANTITY, 후라이드치킨_DEFAULT_PRICE);
    }

    public static EatInOrderLineItem createOrderLineItem(UUID menuId) {
        return createOrderLineItem(menuId, DEFAULT_QUANTITY, 후라이드치킨_DEFAULT_PRICE);
    }

    public static EatInOrderLineItem createOrderLineItem(Menu menu) {
        return createOrderLineItem(menu, DEFAULT_QUANTITY, 후라이드치킨_DEFAULT_PRICE);
    }

    public static EatInOrderLineItem createOrderLineItem(Menu menu, int quantity, BigDecimal price) {
        var orderLineItem = new EatInOrderLineItem();
        orderLineItem.setQuantity(quantity);
        orderLineItem.setMenu(menu);
        orderLineItem.setMenuId(menu.getId());
        orderLineItem.setPrice(price);
        return orderLineItem;
    }
}
