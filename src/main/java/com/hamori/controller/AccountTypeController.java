package com.hamori.controller;

import com.hamori.model.AccountType;
import com.hamori.repository.AccountTypeMapper;
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
public class AccountTypeController {


    @Autowired
    private AccountTypeMapper accountTypeMapper;


    @RequestMapping(value = "accountTypes", method = RequestMethod.GET)
    public List<AccountType> list() {
        return accountTypeMapper.findAll();
    }
}
