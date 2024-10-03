package example.olive_young.domain.product.api.service;

import example.olive_young.domain.product.api.controller.request.EndPromotionRequest;
import example.olive_young.domain.product.api.controller.request.ProductRequest;
import example.olive_young.domain.product.api.controller.request.StartPromotionRequest;
import example.olive_young.domain.product.domain.Product;
import example.olive_young.domain.product.domain.ProductRepository;
import example.olive_young.domain.product.domain.Promotion;
import example.olive_young.domain.product.domain.PromotionPeriod;
import example.olive_young.domain.product.domain.PromotionRepository;
import example.olive_young.domain.product.api.service.response.ProductResponse;
import example.olive_young.domain.product.api.service.response.PromotionStatus;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final PromotionRepository promotionRepository;

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        Product product = createNewProduct(request);
        productRepository.save(product);
        return ProductResponse.from(product);
    }

    @Transactional
    public PromotionStatus startPromotion(StartPromotionRequest request) {
        List<Product> products = findProductsByIdsIn(request.getProductIds());
        List<ProductResponse> productDtos = convertDtos(products);

        PromotionPeriod period = PromotionPeriod.from(LocalDateTime.of(2024, 10, 4, 0, 0), 7);
        Promotion promotion = Promotion.create(period.getStartDate(), period.getEndDate());
        promotionRepository.save(promotion);

        productRepository.assignPromotion(promotion, request.getProductIds());
        return PromotionStatus.from(promotion.getId(), productDtos);
    }

    @Transactional
    public PromotionStatus endPromotion(EndPromotionRequest request) {
        Promotion promotion = findPromotionBy(request.getPromotionId());
        productRepository.updatePromotionToNull(promotion.getId());
        promotionRepository.deleteBy(promotion.getId());
        return PromotionStatus.from(promotion.getId(), Collections.emptyList());
    }

    private static Product createNewProduct(ProductRequest request) {
        return Product.create(request.getProductName(), request.getSaleStartDate(),
            request.getSaleEndDate());
    }

    private Promotion findPromotionBy(Long promotionId) {
        return promotionRepository.findById(promotionId);
    }

    private static List<ProductResponse> convertDtos(List<Product> products) {
        return products.stream()
            .map(ProductResponse::from)
            .toList();
    }

    private static LocalDateTime createStartDate(int year, int month, int day, int hour,
        int minute) {
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    private static LocalDateTime createEndDate(LocalDateTime startDate, int day) {
        return startDate.plusDays(day);
    }

    private List<Product> findProductsByIdsIn(List<Long> productIds) {
        List<Product> products = productRepository.findAllByIdIn(productIds);
        if (products.isEmpty()) {
            throw new IllegalArgumentException("상품이 조회되지 않습니다.");
        }
        return products;
    }
}
