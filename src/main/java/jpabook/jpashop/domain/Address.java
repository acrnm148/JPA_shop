package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/*

값 타입 클래스, 변경 불가

 */
@Embeddable  //JPA의 내장 파일
@Getter
public class Address { //주소 값타입 => 변경불가이므로 Setter제공안함 => jpa생성할 때 리플렉시, 프록시 써야한다. 그럴려면 기본생성자가 있어야 함
    private String city;
    private String street;
    private String zipcode;

    protected Address() { //상속할 일이 없긴한데 JPA스펙 상 맞는거니 함부로 new 생성할 수 없다는 의미를 담고있음
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
