package eg.com.otloblana.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * Created by Mohamed_2 on 11/25/2015.
 */
public class JsonUtil {
    private Gson gson;


    private JsonUtil() {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");

        gson = builder.create();
    }


    public Object fromJson(String jsonStr, Type type) {

        return gson.fromJson(jsonStr,type);

    }
    
    public String toJson(Object object) {
        return gson.toJson(object);
    }

    private static JsonUtil instance;

    public static JsonUtil getInstance() {
        if (instance == null) {
            synchronized (RestUtil.class) {
                if (instance == null) {
                    instance = new JsonUtil();
                }
            }
        }

        return instance;
    }
}


