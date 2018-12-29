package com.lay.mvc.pojo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 17:12 2018/11/13
 * @Modified By:IntelliJ IDEA
 */
public class ValidatorPojo {
    //非空判断
    @NotNull(message = "id不能为空")
    private Long id;

    //只能是将来日期
    @Future(message = "需要一个将来日期")
    //@Past //只能是过去的日期
    @NotNull
    private Date date;

    @NotNull //不能为空
    @DecimalMin(value = "0.1")//最小值0.1
    @DecimalMax(value = "10000.00")//最大值10000.00
    private Double doubleValue = null;

    @NotNull //不能为空
    @Min(value = 1,message = "最小值为1") //最小值为1
    @Max(value = 88,message = "最大值为88") //最大值为88
    private Integer integer;

    @Range(min=1,max=888,message = "范围为1到888")//限定范围
    private Long range;

    @Email(message = "邮箱格式错误") //邮箱验证
    private String email;

    @Size(min=20,max=30,message = "字符串长度要求20到30之间")
    private String size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getRange() {
        return range;
    }

    public void setRange(Long range) {
        this.range = range;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
