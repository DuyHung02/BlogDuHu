package com.example.blog.service;

import com.example.blog.model.Account;
import com.example.blog.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    IAccountRepository iAccountRepository;

    public List<Account> getAll() {
        return (List<Account>) iAccountRepository.findAll();
    }

    public Account checkLogin(String gmail, String password) {
        return iAccountRepository.checkLogin(gmail, password);
    }

    public Boolean checkGmail(String gmail) {
       if (iAccountRepository.checkGmail(gmail) == null) {
           return false;
       }
       return true;
    }

    public void save(Account account) {
        iAccountRepository.save(account);
    }
}
