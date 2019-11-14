package com.gemini.boot.framework.shiro.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户角色
     */
    private List<String> roleName;
}
