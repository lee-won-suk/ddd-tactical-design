package kitchenpos.product.domain.vo;

import jakarta.persistence.Embeddable;
import kitchenpos.external.port.out.PurgomalumClient;

import java.util.Objects;

@Embeddable
public class Name {
    private final String name;

    public Name(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public Name() {
        this.name = "";
    }

    public void containsProfanity(PurgomalumClient purgomalumClient) {
        if (purgomalumClient.containsProfanity(name)) {
            throw new IllegalArgumentException();
        }
    }
}
