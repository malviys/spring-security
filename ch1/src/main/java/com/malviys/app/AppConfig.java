package com.malviys.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {
    @Bean
    UserDetailsService userDetailsServiceBean() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        UserDetails user = User
                .withUsername("root")
                .password("root")
                .authorities("user")
                .build();

        userDetailsManager.createUser(user);

        return userDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoderBean() {
        return NoOpPasswordEncoder.getInstance();
    }
}
