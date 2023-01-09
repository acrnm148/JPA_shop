package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id") //PK
    private Long id;
    private String name;
    @Embedded //내장했다
    private Address address;

    @OneToMany(mappedBy="member") //일대다 관계 //읽기 전용
    private List<Order> orders = new ArrayList<>();
    //여기 값을 넣는다고 해서 FK값이 변경되지 않는다
}
