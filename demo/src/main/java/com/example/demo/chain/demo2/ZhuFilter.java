package com.example.demo.chain.demo2;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:49 2019/7/23
 * @Modified By:IntelliJ IDEA
 */
@Component
public class ZhuFilter implements Filter {

    @Override
    public void doFilter(StringBuilder sb, FilterChain filterChain) {
        StringBuilderUtil.myReplaceAll2(sb, "笨蛋", "**");
        filterChain.doFilter(sb);
    }
}
