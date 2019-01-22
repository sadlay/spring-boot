package com.lay.springboot.beetl.entity;

import org.beetl.sql.core.Tail;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.orm.OrmCondition;
import org.beetl.sql.core.orm.OrmQuery;

import java.io.Serializable;
import java.util.List;
@OrmQuery(
        value = {
                @OrmCondition(target = TRole.class,attr = "id",targetAttr = "userId",sqlId = "tUser.selectRole",type = OrmQuery.Type.MANY,alias = "roleList",lazy = true)
        }
)
public class TUser extends TailBean implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 是否可用
     */
    private Integer available;

    /**
     * 注释
     */
    private String note;

    private List<TRole> roleList;

    public List<TRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * t_user
     */
    private static final long serialVersionUID = 1L;

    public TUser(Integer id, String userName, String pwd, Integer available, String note) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.available = available;
        this.note = note;
    }

    public TUser() {
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
     * 用户名
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 密码
     * @return pwd 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 密码
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 是否可用
     * @return available 是否可用
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * 是否可用
     * @param available 是否可用
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }

    /**
     * 注释
     * @return note 注释
     */
    public String getNote() {
        return note;
    }

    /**
     * 注释
     * @param note 注释
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
        sb.append(", userName=").append(userName);
        sb.append(", pwd=").append(pwd);
        sb.append(", available=").append(available);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}