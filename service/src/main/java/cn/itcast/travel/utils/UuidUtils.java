package cn.itcast.travel.utils;

import java.util.UUID;

public class UuidUtils {
    private UuidUtils(){}
    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
