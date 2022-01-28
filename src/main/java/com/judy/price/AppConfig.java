package com.judy.price;

import com.judy.price.member.MemberRepository;
import com.judy.price.member.MemberService;
import com.judy.price.member.MemberServiceImpl;
import com.judy.price.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

}
