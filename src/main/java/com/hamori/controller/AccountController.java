package com.hamori.controller;

import com.hamori.model.Account;
import com.hamori.repository.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Zoltan_Hamori
 */
@RestController
@RequestMapping("api/")
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;


    @RequestMapping(value = "accounts", method = RequestMethod.GET)
    public List<Account> list() {
        return accountMapper.findAll();
    }

}
