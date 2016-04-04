package com.epam.hamori.repository;

import com.epam.hamori.model.AccountType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Author: Zoltan_Hamori
 */
public interface AccountTypeMapper {

    @Select("SELECT * FROM ACCOUNT_TYPE WHERE name = #{name}")
    AccountType findByName(@Param("name") String name);
}
