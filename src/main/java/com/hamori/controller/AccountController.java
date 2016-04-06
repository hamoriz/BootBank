package com.hamori.controller;

import com.hamori.model.Account;
import com.hamori.repository.AccountMapper;
import com.hamori.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private CustomerMapper customerMapper;


    @Autowired
    private SimpMessagingTemplate template;


    @RequestMapping(value = "accounts", method = RequestMethod.GET)
    public List<Account> list() {
        return accountMapper.findAll();
    }


    @MessageMapping("/accountopen")
    @RequestMapping(value = "accounts", method = RequestMethod.POST)
    public void create(@RequestBody Account account) {
        template.convertAndSend("/topic/accountopen", createAccount(account));
    }


    private Account createAccount(Account account) {
        customerMapper.createCustomer(account.getCustomer());
        accountMapper.createAccount(account);
        return account;
    }

}
