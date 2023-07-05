package jpabook.jpashop.service;

import static org.junit.Assert.*;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;
    @Test
    public void 회원가입(){
        Member member = new Member();
        member.setName("kim");

        Long saveId = memberService.join(member);

        Assertions.assertEquals(member, memberRepository.findOne(saveId));
    }
}