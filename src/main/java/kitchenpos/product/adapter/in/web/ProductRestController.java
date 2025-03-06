package kitchenpos.product.adapter.in.web;

import kitchenpos.product.adapter.in.web.mapper.ProductMapper;
import kitchenpos.product.adapter.in.web.request.ProductRequestDto;
import kitchenpos.product.application.ProductService;
import kitchenpos.product.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/products")
@RestController
public class ProductRestController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductRestController(final ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody final ProductRequestDto request) {
        final Product response = productService.create(productMapper.mapProduct(request));
        return ResponseEntity.created(URI.create("/api/products/" + response.getId()))
                .body(response);
    }

    @PutMapping("/{productId}/price")
    public ResponseEntity<Product> changePrice(@PathVariable final UUID productId, @RequestBody final Product request) {
        return ResponseEntity.ok(productService.changePrice(productId, request));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }
}
