package com.lay.utils.util.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:02 2019/3/13
 * @Modified By:IntelliJ IDEA
 */
public class Main {

    public static void main(String[] args) {
        //String s = JSONObject.toJSONString(getResult());
        JSONObject jsonObject =  JSON.parseObject(JSON_OBJECT_STRING);
        Map<String,Object> map=(Map)jsonObject;
        for (Map.Entry<String, Object> mapEntry : map.entrySet()) {
            List<Map<String,Object>> list = (List) mapEntry.getValue();
            System.out.println(JSONObject.toJSONString("before "+list));
            list.sort(new Comparator<Map<String, Object>>() {
                @Override
                public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                    String name = (String)o1.get("name");
                    String name2 = (String)o2.get("name");
                    if(name.contains("-")&&name2.contains("-")){
                        String[] temp1 = name.split("-");
                        String[] temp2 = name2.split("-");
                        float var1=Float.parseFloat(temp1[0]);
                        float var2=Float.parseFloat(temp2[0]);
                        return Float.compare(var1,var2);
                    }
                    return name.compareTo(name2);
                }
            });
            System.out.println(JSONObject.toJSONString("after "+list));
        }

    }

    public static Map<String, Object> getResult() {
        Map<String, Object> result = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            List<Map<String, Object>> list =new ArrayList<>();
            for (int y = 0; y < 10; y++) {
                Map<String, Object> listMap = new HashMap<>();
                listMap.put("name",getNumberName());
                list.add(listMap);
            }
            result.put(getName(), list);
        }
        return result;

    }

    public static String getNumber() {
        return RandomStringUtils.randomNumeric(1) + "." + RandomStringUtils.randomNumeric(1);
    }

    public static String getName() {
        return RandomStringUtils.random(4, "系统康说明的所发生的士大夫省士大夫撒额的发地方欸哦发登陆密码节点发送嗯发送发顺丰昂书发顺丰的是否都是大否带啊发送欸付是发地方昂书范达尔发送");
    }

    public static String getNumberName() {
        return getNumber() + getName();
    }

    private static final String JSON_OBJECT_STRING="{\n" +
            "    \"丰额康额\": [\n" +
            "        {\n" +
            "            \"name\": \"1.-嗯都地带\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"10.6-密送夫尔\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"1.2-尔明额发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"4.0-的送否带\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"2.6-康送登书\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"2.1顺发发都\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"7.5-发士省发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"发统的士\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"3.9-顺范欸大\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"3.4发顺额送\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"发大书统\": [\n" +
            "        {\n" +
            "            \"name\": \"1.6发方明发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"6.5顺省是达\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"5.1都说昂大\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"1.2夫说康夫\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"3.6送顺是发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"2.0陆士发发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"0.0送方昂密\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"1.9省都书丰\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"1.2陆大登士\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"9.0的书统的\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"否送额否\": [\n" +
            "        {\n" +
            "            \"name\": \"0.6否密书否\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"6.4密范送丰\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"8.4发是发点\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"5.3都发顺的\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"4.7嗯的点发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"9.9地发方地\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"4.8哦是欸丰\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"9.6都统发陆\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"3.0大发哦方\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"9.7发尔顺点\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"夫昂夫发\": [\n" +
            "        {\n" +
            "            \"name\": \"2.3发密欸密\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"3.1发发额明\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"4.9发大送发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"7.9大节说陆\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"0.0密送夫发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"8.3系的省点\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"5.6所都地夫\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"5.7丰送发省\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"3.5大书否地\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"6.6的点发陆\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"顺尔发的\": [\n" +
            "        {\n" +
            "            \"name\": \"4.1地系书额\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"7.8-说丰发是\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"4.1发撒地丰\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"3.4啊达康大\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"9.9-的密昂书\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"2.6地士哦点\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"2.5发丰发撒\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"8.5丰达大发\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"1.7发省送大\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"0.8哦方发发\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

}
