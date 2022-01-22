package com.example.nitaxcodingchallenge.security.security_service;


import com.example.nitaxcodingchallenge.model.Account;
import com.example.nitaxcodingchallenge.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String accountNumber) throws UsernameNotFoundException {

        Account account = this.accountService.getAccountMap().get(accountNumber);

        if (account == null) {
            throw new ApiResourceNotFoundException( accountNumber + " does not exist in our database");
        }

        return UserDetailsImpl.build(account);
    }
}
