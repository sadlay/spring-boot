package com.lay.springboot.beetl.entity;


import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.orm.OrmCondition;
import org.beetl.sql.core.orm.OrmQuery;

import java.io.Serializable;
import java.util.List;

@OrmQuery(
        value = {
                @OrmCondition(target = TUser.class,attr = "id",targetAttr = "roleId",sqlId = "tRole.selectUser",type = OrmQuery.Type.MANY,alias = "userList",lazy = false)
        }
)
public class TRole extends TailBean implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String note;

    private List<TUser> userList;

    public List<TUser> getUserList() {
        return userList;
    }

    public void setUserList(List<TUser> userList) {
        this.userList = userList;
    }

    /**
     * t_role
     */
    private static final long serialVersionUID = 1L;

    public TRole(Integer id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
    }

    public TRole() {
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
     * 角色名称
     * @return role_name 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 备注
     * @return note 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 备注
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}