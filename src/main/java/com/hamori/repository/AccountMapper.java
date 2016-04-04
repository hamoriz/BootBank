package com.hamori.repository;

import com.hamori.model.Account;
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
    List<Account> findByCustomer(@Param("customer") Customer id);

    @Insert("INSERT INTO ACCOUNT (balance, customer_id) VALUES (#{account.balance}, #{account.customer.id})")
    Long createAccount(@Param("account") Account account);


    @Select("SELECT * FROM ACCOUNT")
    @Results(value = {
            @Result(property="balance", column="balance"),
            @Result(property="customer", javaType=List.class, column="customerId",
                    one=@One(select="findCustomer"))
    })
    List<Account> findAll();

    @Select("SELECT * FROM CUSTOMER WHERE id=#{account.customerId}")
    Customer findCustomer(Account account);
}
