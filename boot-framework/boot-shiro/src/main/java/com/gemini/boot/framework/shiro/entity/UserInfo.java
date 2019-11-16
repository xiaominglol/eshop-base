package com.gemini.boot.framework.shiro.entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

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
     * 用户头像
     */
    private String picture;

    /**
     * 用户角色
     */
    private Set<String> roles;
    /**
     * 用户权限
     */
    private Set<String> permissions;
}
