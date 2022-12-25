package com.BankApplication.configuration;

import com.BankApplication.entity.Customer;
import com.BankApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankUserDetailsManager implements UserDetailsService {
    @Autowired
    public CustomerRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> loaded=repository.findByUsername(username);
        if(loaded==null || loaded.size()==0){
            throw new UsernameNotFoundException("NO USER FOUND");
        }
        UserDetails userDetails= User.withUsername(loaded.get(0).getUsername()).password(loaded.get(0).getPassword()).authorities(loaded.get(0).getRole()).build();
        return userDetails;
    }
}
