package example.olive_young.domain.order.api.controller;

import example.olive_young.domain.order.api.controller.request.OrderRequest;
import example.olive_young.domain.order.api.service.OrderService;
import example.olive_young.domain.order.api.service.response.OrderResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/v1/order")
    public List<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

}
