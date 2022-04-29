package com.spring.class2.configs;

import com.spring.class2.service.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spring.class2.service"})
public class RootConfig {

    @Bean
    public Account accountDetails(){
        Account account = new Account();
        account.setAccountId("0001");
        account.setAccountType("Student");
        account.setAccountHolderName("Sufyan Khan");
        return account;
    }
}
