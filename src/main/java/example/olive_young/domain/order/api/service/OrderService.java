package example.olive_young.domain.order.api.service;

import example.olive_young.domain.cartproduct.domain.CartItemRepository;
import example.olive_young.domain.order.domain.OrderRepository;
import example.olive_young.domain.order.api.controller.request.OrderRequest;
import example.olive_young.domain.order.api.service.response.OrderResponse;
import example.olive_young.domain.order.domain.Order;
import example.olive_young.domain.orderproduct.domain.OrderItem;
import example.olive_young.domain.orderproduct.domain.OrderItemRepository;
import example.olive_young.domain.product.domain.Product;
import example.olive_young.domain.product.domain.ProductRepository;
import example.olive_young.domain.user.domain.User;
import example.olive_young.domain.user.domain.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public List<OrderResponse> createOrder(OrderRequest request) {
        User orderUser = findUserById(request);
        List<Product> orderProducts = findProductsByIds(request.getProductIds());

        // 상품 주문
        List<OrderItem> orderItems = createOrderItems(orderProducts, orderUser);
        orderItemRepository.saveAll(orderItems);

        // 주문된 상품은 장바구니에서 삭제
        removeCartItems(request, orderUser);

        return orderItems.stream()
            .map(oi -> OrderResponse.create(orderUser.getId(), oi.getId()))
            .toList();
    }

    @Transactional(readOnly = true)
    public boolean isOrderAvailable(Long productId) {
        Product product = productRepository.findById(productId);
        return product.isAvailable();
    }

    private void removeCartItems(OrderRequest request, User orderUser) {
        cartItemRepository.removeProductsFromCart(orderUser.getId(), request.getProductIds());
    }

    private List<OrderItem> createOrderItems(List<Product> products, User user) {
        List<OrderItem> orderItems = new ArrayList<>();
        addProducts(products, user, orderItems);
        return orderItems;
    }

    private void addProducts(List<Product> products, User user, List<OrderItem> orderItems) {
        for (Product product : products) {
            Order order = Order.create(user);
            orderRepository.save(order);
            orderItems.add(OrderItem.create(order, product));
        }
    }

    private User findUserById(OrderRequest request) {
        return userRepository.findById(request.getUserId());
    }

    private List<Product> findProductsByIds(List<Long> productIds) {
        return productRepository.findAllByIdIn(productIds);
    }

}
