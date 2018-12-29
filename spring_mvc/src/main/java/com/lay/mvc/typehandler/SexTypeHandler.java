package com.lay.mvc.typehandler;

import com.lay.mvc.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:38 2018/11/11
 * @Modified By:IntelliJ IDEA
 */
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    //通过列名读取性别
    @Override
    public SexEnum getNullableResult(ResultSet rs, String col) throws SQLException {
        int sex = rs.getInt(col);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    //通过下标读取性别
    @Override
    public SexEnum getNullableResult(ResultSet rs, int idx) throws SQLException {
        int sex = rs.getInt(idx);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    //通过存储存储过程读取性别
    @Override
    public SexEnum getNullableResult(CallableStatement rs, int idx) throws SQLException {
        int sex = rs.getInt(idx);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    //设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement ps, int idx, SexEnum sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(idx, sex.getId());
    }

}
