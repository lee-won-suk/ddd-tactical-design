package kitchenpos.product.domain;

import jakarta.persistence.*;
import kitchenpos.product.domain.vo.Name;
import kitchenpos.product.domain.vo.Price;

import java.math.BigDecimal;
import java.util.UUID;


@Table(name = "product")
@Entity
public class Product {
    @Column(name = "id", columnDefinition = "binary(16)")
    @Id
    private UUID id;

    @Embedded
    @Column(name = "name", nullable = false)
    private Name name;

    @Embedded
    @Column(name = "price", nullable = false)
    private Price price;

    public Product() {

    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setPrice(BigDecimal price) {
        this.price = new Price(price);
    }

    public Product(UUID uuid, String name, BigDecimal price) {
        this.id = uuid;
        this.name = new Name(name);
        this.price = new Price(price);
    }
    public Product(UUID uuid, Name name, Price price) {
        this.id = uuid;
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

}
