package jpabook.jpashop.repository;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    private Long id;

    private int price;
    private int stockQuantity;

    private String name;

    private String author;
    private String isbn;
}
