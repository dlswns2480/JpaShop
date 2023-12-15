package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.exception.NotEnoughStockException;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.fail;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    private final EntityManager em;
    private final OrderService orderService;
    private final OrderRepository orderRepository;
    @Autowired
    public OrderServiceTest(EntityManager em, OrderService orderService,
        OrderRepository orderRepository) {
        this.em = em;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }
    @Test
    void test(){
        Assertions.assertThat(1+1).isEqualTo(2);
    }
//    @Test
//    public void 상품주문() throws Exception{
//        Member member = createMember();
//
//        Book book = createBook("Jpa book", 10000, 10);
//
//        int orderCount = 2;
//        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
//
//        Order getOrder = orderRepository.findOne(orderId);
//
//        Assert.assertEquals("상품 상태는 주문이어야 합니다", OrderStatus.ORDER, getOrder.getStatus());
//        Assert.assertEquals("주문한 상품의 종류수가 정확해야 한다.", 1, getOrder.getOrderItems().size());
//        Assert.assertEquals("총 주문 가격은 가격 * 수량이다.", book.getPrice() * orderCount, getOrder.getTotalPrice());
//        Assert.assertEquals("주문 수량만큼 재고가 줄어야한다.", 8, book.getStockQuantity());
//    }
//    @Test(expected = NotEnoughStockException.class)
//    public void 상품주문시_재고수량초과() throws Exception{
//        Member member = createMember();
//        Item item = createBook("Jpa book", 10000, 10);
//
//        int orderCount = 12;
//
//        orderService.order(member.getId(), item.getId(), orderCount);
//
//
//        //이전에서 예외가 터져야함
//        fail("여기까지 오면 안된다");
//    }
//    @Test
//    public void 주문취소() throws Exception{
//        Member member = createMember();
//        Book item = createBook("JPA book", 10000, 10);
//
//        int orderCount = 2;
//        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);
//        Order getOrder = orderRepository.findOne(orderId);
//
//        Assert.assertEquals("주문한만큼 재고가 줄어야한다.", 8, item.getStockQuantity());
//
//        orderService.cancel(orderId);
//        Assert.assertEquals("주문 취소시 재고가 원복 되어있어야한다.", 10, item.getStockQuantity());
//        Assert.assertEquals("주문상태는 CANCEL이어야한다.", OrderStatus.CANCEL, getOrder.getStatus());
//    }
//
//    private Book createBook(String name, int price, int stockQuantity) {
//        Book book = new Book();
//        book.setName(name);
//        book.setPrice(price);
//        book.setStockQuantity(stockQuantity);
//        em.persist(book);
//        return book;
//    }
//
//    private Member createMember() {
//        Member member = new Member();
//        member.setName("회원1");
//        member.setAddress(new Address("서울시", "강가", "123-123"));
//
//        em.persist(member);
//        return member;
//    }
}