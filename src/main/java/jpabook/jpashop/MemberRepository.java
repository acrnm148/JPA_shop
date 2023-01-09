package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
repository : Entity를 찾아주는 녀석 (DTO랑 비슷)
 */
@Repository //component 스캔 대상이므로 자동으로 spring에 bean 등록
public class MemberRepository {
    @PersistenceContext //EntityManager를 생성하는 코드가 없어도 자동으로 주입해줌
    private EntityManager em; //JPA를 사용하려면 EntityManager가 필요

    public Long save(Member member) { //insert
        em.persist(member);
        return member.getId(); //insert 일어난 후 id를 리턴하도록 함
    }

    public Member find(Long id) {
        return em.find(Member.class, id); //select
    }
}
