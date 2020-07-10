package com.safez.project.util;

import net.sf.json.JSONObject;
import org.eclipse.jetty.util.ajax.JSON;

public class JsonUtil {



 public static <T extends Object> T fromObject(String jsonStr, Class<T> clazz){
        JSONObject jsonObject = (JSONObject) JSON.parse(jsonStr);
        Class<T> c= (Class) JSONObject.toBean(jsonObject,clazz);
        return (T) c;
    }

}
