package example.olive_young.domain.product.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PromotionPeriod {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private PromotionPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static PromotionPeriod from(LocalDateTime startDate, int durationDays) {
        return new PromotionPeriod(startDate, startDate.plusDays(durationDays));
    }

}
