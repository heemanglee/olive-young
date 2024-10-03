package example.olive_young.domain.product.api.controller;

import example.olive_young.domain.product.api.controller.request.EndPromotionRequest;
import example.olive_young.domain.product.api.controller.request.ProductRequest;
import example.olive_young.domain.product.api.controller.request.StartPromotionRequest;
import example.olive_young.domain.product.api.service.ProductService;
import example.olive_young.domain.product.api.service.response.ProductResponse;
import example.olive_young.domain.product.api.service.response.PromotionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/v1/products")
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    @PostMapping("/v1/products/start-promotion")
    public PromotionStatus startPromotion(@RequestBody StartPromotionRequest request) {
        return productService.startPromotion(request);
    }

    @PostMapping("/v1/products/end-promotion")
    public PromotionStatus endPromotion(@RequestBody EndPromotionRequest request) {
        return productService.endPromotion(request);
    }


}
