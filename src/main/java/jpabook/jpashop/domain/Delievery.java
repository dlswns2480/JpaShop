package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

@Entity
@Getter @Setter
public class Delievery {
    @Id @GeneratedValue
    @Column(name = "delievery_id")
    private Long id;

    @OneToOne(mappedBy = "delievery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DelieveryStatus status; //Enum으로 READY, COMP 구성
}
