package com.example.demo.chain.demo2;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:48 2019/7/23
 * @Modified By:IntelliJ IDEA
 */
public interface Filter {

    void doFilter(StringBuilder sb, FilterChain filterChain);

}
