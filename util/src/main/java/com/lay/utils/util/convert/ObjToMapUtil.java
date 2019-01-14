package com.lay.utils.util.convert;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @Description: Object和Map转换工具类
 * @Author: lay
 * @Date: Created in 19:02 2019/1/10
 * @Modified By:IntelliJ IDEA
 */
public class ObjToMapUtil {

    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }
        Object obj = beanClass.newInstance();
        BeanUtils.populate(obj, map);
        return obj;
    }
}
