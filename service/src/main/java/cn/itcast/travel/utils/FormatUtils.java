package cn.itcast.travel.utils;

public class FormatUtils {

    public int formatNum(String str, int defaultVal) {
        return str != null && str.length() > 0 && !"null".equals(str) ? Integer.parseInt( str ) : defaultVal;
    }

}
