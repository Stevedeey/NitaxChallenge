package com.example.nitaxcodingchallenge.security.security_service;

import com.example.nitaxcodingchallenge.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String accountName;

    private String accountNumber;

    private Double balance;

    @JsonIgnore
    private String password;

    public UserDetailsImpl(String accountName, String accountNumber, Double balance, String password) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }

    public static UserDetailsImpl build(Account account){
        return  new UserDetailsImpl(account.getAccountName(),
                account.getAccountNumber(),account.getBalance(),
                account.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return accountNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl account = (UserDetailsImpl) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }
}
