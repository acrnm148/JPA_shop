package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;
    @ManyToMany //실무에서는 매니투매니 절대 쓰지마라 - 중간테이블에 값을 넣을 수 없다. 일대다-다대일로 풀어라
    @JoinTable(name="category_item", //이거 테이블 이름임
        joinColumns=@JoinColumn(name="category_id"),
            inverseJoinColumns = @JoinColumn(name="item_id")
    )
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Category parent; //내 부모니까 manytoone

    @OneToMany(mappedBy="parent") //이름만 내꺼지 다른엔티티와 연결하는식으로 연관관계를 설정
    private List<Category> child = new ArrayList<> ();
}
