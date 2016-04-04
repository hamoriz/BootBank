package com.hamori.repository;

import com.hamori.model.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Zoltan_Hamori on 4/4/2016.
 */
public interface CustomerMapper {

    @Select("SELECT * FROM CUSTOMER WHERE id = #{id}")
    Customer findById(@Param("id") Long id);

    @Select("SELECT * FROM CUSTOMER WHERE name = #{name}")
    Customer findByName(@Param("name") String name);

    @Select("SELECT * FROM CUSTOMER")
    List<Customer> findAll();

    @Insert("INSERT INTO CUSTOMER (name) values(#{customer.name})")
    @Options(keyProperty = "customer.id", useGeneratedKeys = true, keyColumn = "id")
    void createCustomer(@Param("customer") Customer customer);


}
