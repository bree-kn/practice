package com.example.practice.mapper;

import com.example.practice.mybatis.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MybatisMapper {
    @Select("select * from user where id=#{id}")
    User getUser(@Param("id") int id);

    @Insert("insert into user(userName,password,realName,tes) values(#{name},'dd','d','d')")
    void insert(@Param("name")String name);

    @Update("update user set userName='sto' where id=#{i}")
    void update(int i);
}
