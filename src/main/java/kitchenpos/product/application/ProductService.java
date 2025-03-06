package kitchenpos.product.application;

import kitchenpos.external.port.out.PurgomalumClient;
import kitchenpos.menu.application.port.out.MenuRepository;
import kitchenpos.menu.domain.Menu;
import kitchenpos.menu.domain.MenuProduct;
import kitchenpos.product.application.port.out.ProductRepository;
import kitchenpos.product.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final MenuRepository menuRepository;
    private final PurgomalumClient purgomalumClient;

    public ProductService(
            final ProductRepository productRepository,
            final MenuRepository menuRepository,
            final PurgomalumClient purgomalumClient
    ) {
        this.productRepository = productRepository;
        this.menuRepository = menuRepository;
        this.purgomalumClient = purgomalumClient;
    }

    @Transactional
    public Product create(final Product request) {
        final var name = request.getName();
        name.containsProfanity(purgomalumClient);
        final Product product = new Product(UUID.randomUUID(),name, request.getPrice());
        return productRepository.save(product);
    }

    @Transactional
    public Product changePrice(final UUID productId, final Product request) {
        final var price = request.getPrice();

        final Product product = productRepository.findById(productId)
                .orElseThrow(NoSuchElementException::new);
        product.setPrice(price);
        final List<Menu> menus = menuRepository.findAllByProductId(productId);
        for (final Menu menu : menus) {
            BigDecimal sum = BigDecimal.ZERO;
            for (final MenuProduct menuProduct : menu.getMenuProducts()) {
                sum = sum.add(
                        menuProduct.getProduct()
                                .getPrice()
                                .multiplyPrice(menuProduct.getQuantity())
                );
            }
            if (menu.getPrice().compareTo(sum) > 0) {
                menu.setDisplayed(false);
            }
        }
        return product;
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
