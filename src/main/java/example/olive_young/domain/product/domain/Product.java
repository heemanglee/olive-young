package example.olive_young.domain.product.domain;

import example.olive_young.global.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime saleStartDate; // 판매 시작일
    private LocalDateTime saleEndDate; // 판매 종료일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @Builder
    private Product(String name, LocalDateTime saleEndDate, LocalDateTime saleStartDate) {
        this.name = name;
        this.saleEndDate = saleEndDate;
        this.saleStartDate = saleStartDate;
    }

    public static Product create(String name, LocalDateTime saleEndDate, LocalDateTime saleStartDate) {
        return Product.builder()
            .name(name)
            .saleEndDate(saleEndDate)
            .saleStartDate(saleStartDate)
            .build();
    }

}
