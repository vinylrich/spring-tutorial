package com.example.springtutorial;

import com.example.springtutorial.repository.JdbcMemberRepository;
import com.example.springtutorial.repository.MemberRepository;
import com.example.springtutorial.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService MemberService() {
        return new MemberService(MemberRepository());
    }
    @Bean
    public MemberRepository MemberRepository() {
        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}