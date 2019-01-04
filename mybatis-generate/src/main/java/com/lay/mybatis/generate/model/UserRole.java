package com.lay.mybatis.generate.model;

import java.io.Serializable;

public class UserRole implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * t_user_role
     */
    private static final long serialVersionUID = 1L;

    public UserRole(Integer id, Integer roleId, Integer userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

    public UserRole() {
        super();
    }

    /**
     * 自增主键
     * @return id 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自增主键
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色id
     * @return role_id 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}