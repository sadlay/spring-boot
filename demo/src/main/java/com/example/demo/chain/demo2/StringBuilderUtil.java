package com.example.demo.chain.demo2;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:26 2019/7/24
 * @Modified By:IntelliJ IDEA
 */
public class StringBuilderUtil {

    public static StringBuilder myReplaceAll(StringBuilder stb, String oldStr, String newStr) {
        if (stb == null || oldStr == null || newStr == null || stb.length() == 0 || oldStr.length() == 0)
            return stb;
        int index = stb.indexOf(oldStr);
        if (index > -1 && !oldStr.equals(newStr)) {
            int lastIndex = 0;
            while (index > -1) {
                stb.replace(index, index + oldStr.length(), newStr);
                lastIndex = index + newStr.length();
                index = stb.indexOf(oldStr, lastIndex);
            }
        }
        return stb;
    }

    public static StringBuilder myReplaceAll2(StringBuilder stb, String oldStr, String newStr) {
        if (stb == null || oldStr == null || newStr == null || stb.length() == 0 || oldStr.length() == 0)
            return stb;
        int index = stb.indexOf(oldStr);
        if (index > -1 && !oldStr.equals(newStr)) {
            stb.replace(index, index + oldStr.length(), newStr);
            myReplaceAll2(stb, oldStr, newStr);
        }
        return stb;
    }
}
