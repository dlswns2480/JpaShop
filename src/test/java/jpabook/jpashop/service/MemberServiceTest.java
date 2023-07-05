package jpabook.jpashop.service;

import static org.junit.Assert.*;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //JUnit 실행할때 스프링도 같이 엮어서 실행하고 싶을 때.
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private EntityManager em;
    @Test
    public void 회원가입(){
        Member member = new Member();
        member.setName("kim");

        Long saveId = memberService.join(member);

        em.flush(); //원래는 Transactional로 인해 Rollback이 발생해 DB 쿼리를 날리지 않지만 쿼리를 보고싶을때 flush를 사용
        Assertions.assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_검증 (){
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("kim");
        member2.setName("kim");

        memberService.join(member1);
        memberService.join(member2);

        fail("예외가 발생해야 한다. 여기까지 내려오면 안된다.");
    }
}