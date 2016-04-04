package com.epam.hamori.repository;

import com.epam.hamori.model.Account;
import com.epam.hamori.model.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    List<Account> findByCustomer(@Param("customer") Customer id);

    @Insert("INSERT INTO ACCOUNT (balance, customer_id) VALUES (#{account.balance}, #{account.customer.id})")
    Long createAccount(@Param("account") Account account);



}
