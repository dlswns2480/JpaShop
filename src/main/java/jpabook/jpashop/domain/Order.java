package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    @JoinColumn(name = "delievery_id")
    private List<OrderItem> orderItems = new ArrayList<>();

    private Delievery delievery;

    private LocalDateTime orderDate;

    private OrderStatus status; //Enum type으로 [ORDER, CANCEL]


}
