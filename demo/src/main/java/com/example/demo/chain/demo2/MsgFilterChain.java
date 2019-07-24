package com.example.demo.chain.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 23:51 2019/7/23
 * @Modified By:IntelliJ IDEA
 */
public class MsgFilterChain implements FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public MsgFilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public void doFilter(StringBuilder sb) {
        if (index == filters.size()) {
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(sb, this);
    }
}
