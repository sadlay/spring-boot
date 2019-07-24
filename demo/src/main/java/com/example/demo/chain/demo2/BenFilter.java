package com.example.demo.chain.demo2;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:49 2019/7/23
 * @Modified By:IntelliJ IDEA
 */
public class BenFilter implements Filter {

    @Override
    public void doFilter(StringBuilder sb, FilterChain filterChain) {
        StringBuilderUtil.myReplaceAll2(sb, "猪", "*");
        filterChain.doFilter(sb);
    }
}
