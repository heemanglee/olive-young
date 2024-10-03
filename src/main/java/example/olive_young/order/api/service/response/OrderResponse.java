package example.olive_young.order.api.service.response;

import lombok.Getter;

@Getter
public class OrderResponse {

    private Long userId;
    private Long orderId;

    private OrderResponse(Long userId, Long orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }

    public static OrderResponse create(Long userId, Long orderId) {
        return new OrderResponse(userId, orderId);
    }

}
