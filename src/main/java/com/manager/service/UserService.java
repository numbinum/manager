package com.manager.service;

import java.util.List;

import com.manager.dto.UserDto;
import com.manager.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;

    public List<UserDto> selectUserList() throws Exception{
        return userMapper.selectUserList();
    }

    public void insertUser(UserDto userDto) throws Exception{
        userMapper.insertUser(userDto);
    }

    public void updatePass(UserDto userDto) throws Exception{
        userMapper.updatePass(userDto);
    }

    public void deleteUser(int idx) throws Exception{
        userMapper.deleteUser(idx);
    }
}