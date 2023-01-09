package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member); //member 저장
        System.out.println("~~~~~~~~~~~saveId = " + saveId);
        Member findMember = memberRepository.find(saveId); //save가 잘되었는지 select

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername()); //isEqualTo : 식별자(해시코드)가 같으면 같은 엔티티로 인식한다
        Assertions.assertThat(findMember).isEqualTo(member); //findMember: 조회한것, member: 저장한 것
        System.out.println("findMember == member: " + (findMember==member));
        /*
        저장한 member와 조회한 findMember는 같을까?
        => findMember == member 같다.
         */

    }
    
    
}