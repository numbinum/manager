package com.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.manager.dto.UserDto;

@Mapper
public interface UserMapper{
    List<UserDto> selectUserList() throws Exception;
    void insertUser(UserDto userDto) throws Exception;
    void updatePass(UserDto userDto) throws Exception;
    void deleteUser(int idx) throws Exception;
}