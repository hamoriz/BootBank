package com.hamori.repository;

import com.hamori.model.Account;
import com.hamori.model.AccountType;
import com.hamori.model.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zoltan_Hamori on 4/4/2016.
 */
@Repository
public interface AccountMapper {

    @Select("SELECT * FROM ACCOUNT WHERE id = #{id}")
    Account findById(@Param("id") Long id);


    @Select("SELECT * FROM ACCOUNT WHERE customer_id = #{customer.id}")
    List<Account> findByCustomer(@Param("customer") Customer customer);


    @Insert("INSERT INTO ACCOUNT (balance, customer_id, account_type_id) VALUES (#{account.balance}, #{account.customer.id}, #{account.type.id})")
    @Options(keyProperty = "account.id", useGeneratedKeys = true, keyColumn = "id")
    Long createAccount(@Param("account") Account account);


    @Select("SELECT * FROM ACCOUNT")
    @Results(value = {
            @Result(property = "balance", column = "balance"),
            @Result(property = "customer", column = "customer_id", javaType = Customer.class, one = @One(select = "com.hamori.repository.CustomerMapper.findById")),
            @Result(property = "type", column = "account_type_id", javaType = AccountType.class, one = @One(select = "com.hamori.repository.AccountTypeMapper.findById"))
    })
    List<Account> findAll();


}
