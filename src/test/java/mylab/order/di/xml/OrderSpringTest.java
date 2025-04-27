package mylab.order.di.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class OrderSpringTest {

    ApplicationContext context;

    @BeforeEach
    void container() {
        // 1. Container 객체 생성
        context = new GenericXmlApplicationContext("classpath:mylab-order-di.xml");
    }

    @Test
    void shoppingCartBeanTest() {
        // 2. ShoppingCart 빈 요청
        ShoppingCart cartById = (ShoppingCart) context.getBean("shoppingCart");
        ShoppingCart cartByType = context.getBean("shoppingCart", ShoppingCart.class);

        // 주소 비교
        assertSame(cartById, cartByType);

        // Product 리스트 크기 테스트
        assertEquals(2, cartById.getProducts().size());

        // 총 가격 테스트
        double expectedTotal = 1500.0 + 800.0;
        assertEquals(expectedTotal, cartById.getTotalPrice(), 0.001);

        System.out.println("ShoppingCart 테스트: " + cartById);
    }

    @Test
    void orderServiceBeanTest() {
        // 2. OrderService 빈 요청
        OrderService serviceById = (OrderService) context.getBean("orderService");
        OrderService serviceByType = context.getBean("orderService", OrderService.class);

        // 주소 비교
        assertSame(serviceById, serviceByType);

        // 총 주문 금액 테스트
        double expectedTotal = 1500.0 + 800.0;
        assertEquals(expectedTotal, serviceById.calculateOrderTotal(), 0.001);

        System.out.println("OrderService 테스트: " + serviceById);
    }
}
