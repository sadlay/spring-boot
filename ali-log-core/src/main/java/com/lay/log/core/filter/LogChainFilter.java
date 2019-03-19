package com.lay.log.core.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

import java.util.Map;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:02 2019/3/19
 * @Modified By:IntelliJ IDEA
 */
public class LogChainFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        Map<String, String> mdcPropertyMap = iLoggingEvent.getMDCPropertyMap();
        if (mdcPropertyMap.get("req.requestNo") != null) {
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
