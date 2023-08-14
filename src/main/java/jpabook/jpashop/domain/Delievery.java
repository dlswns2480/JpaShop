package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

@Entity
@Getter @Setter
public class Delievery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delievery_id")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "delievery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DelieveryStatus status; //Enum으로 READY, COMP 구성
}
