package com.lay.filedemo.core;

import java.util.HashMap;
import java.util.Map;

/***
 * @ClassName: R
 * @Auther: zhaogengsheng
 * @Date: 2019/4/30 9:17
 * Copyright: 2018赛鼎科技-版权所有
 */
public class R {

    /**
     * 处理上传文件结果
     *
     * @auther: lay
     * @date: 10:50 2018/11/15
     */
    public static Map<String, Object> Result(boolean success, String msg) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("msg", msg);
        return result;
    }
}
