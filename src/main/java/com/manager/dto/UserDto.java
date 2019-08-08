package com.manager.dto;

import lombok.Data;

@Data
public class UserDto{
    private int idx;
    
    private String userId;

    private String pass;
    
	private String createdDatetime;
}