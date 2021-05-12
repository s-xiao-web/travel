package cn.itcast.travel.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostParamterUtils {

    public static Map<String, String> getPostParams(HttpServletRequest req) throws IOException {
        String contentType = req.getContentType();

        Map<String, String> mapData = new HashMap<>();

        if (contentType != null && !contentType.equals("")) {
            contentType = contentType.split(";")[0];
        }

        if ("application/json".equalsIgnoreCase(contentType)) {
            String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
            Map parseObject = JSON.parseObject(paramJson, Map.class);
            mapData.putAll(parseObject);
        }
        return mapData;
    }

}
