package kitchenpos.product.domain;

import kitchenpos.product.domain.vo.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PriceTest {
    @DisplayName("price가 없으면 안됩니다.")
    @NullAndEmptySource()
    @ParameterizedTest
    void multiplyPriceTest(String testPrice) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Price(BigDecimal.valueOf(Integer.parseInt(testPrice))));
    }

    @DisplayName("price는 0원 이상이어야 합니다.")
    @Test()
    void multiplyPriceZeroTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Price(BigDecimal.valueOf(-1)));
    }

}
