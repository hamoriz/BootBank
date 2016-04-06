package com.hamori.repository;

import com.hamori.model.AccountType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author: Zoltan_Hamori
 */
public interface AccountTypeMapper {

    @Select("SELECT * FROM ACCOUNT_TYPE WHERE name = #{name}")
    AccountType findByName(@Param("name") String name);

    @Select("SELECT * FROM ACCOUNT_TYPE WHERE id = #{id}")
    AccountType findById(@Param("name") Long id);

    @Select("SELECT * FROM ACCOUNT_TYPE")
    List<AccountType> findAll();


}
