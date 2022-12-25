package com.BankApplication.configuration;

import com.BankApplication.entity.Customer;
import com.BankApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankApplicationAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    public CustomerRepository repository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String requestedPassword = (String) authentication.getCredentials(); // row password
        String requestUserName = authentication.getName(); // login username
        List<Customer> customers = repository.findByUsername(requestUserName);
        if (customers == null || customers.size() == 0) {
            throw new RuntimeException("NO USER FOUND FOR GIVEN USER NAME");
        }
        if (!passwordEncoder.matches(requestedPassword, customers.get(0).getPassword())) {
            throw new RuntimeException(" INVALID CREDENTIALS EXCEPTINO");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        return new UsernamePasswordAuthenticationToken(requestUserName, customers.get(0).getPassword(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
