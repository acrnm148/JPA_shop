package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    //다대일 관계
    @ManyToOne
    @JoinColumn(name="member_id") //FK 이름이 member_id
    private Member member;

    //여기서 값을 바꿔주면 값이 바뀐다. (관계테이블)

    //맵핑된게 없어서 빨간줄이 뜬다
    @OneToMany(mappedBy="order") //order에 대해서 맵핑됐다
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery; //다대일-일대다 연관관계의 주인 : 관계테이블안의 FK

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]

}
