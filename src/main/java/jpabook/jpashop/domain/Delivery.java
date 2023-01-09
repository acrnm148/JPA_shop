package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name="delivery_id") //연관관계 주인
    private Long id;
    @OneToOne(mappedBy = "delivery")
    private Order order;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING) //enum을 쓸거면 어노테이션으로 명시해줘야함
    private DeliveryStatus status; //READY, COMP - 배송중비, 배송
}
