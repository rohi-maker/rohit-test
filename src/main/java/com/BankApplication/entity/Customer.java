package com.BankApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    @GenericGenerator(name = "incgenerator", strategy = "increment")
    @GeneratedValue(generator = "incgenerator")
    private long id;

    private String username;
    private String password;
    private int enabled;
    private String role;
}
