package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private static Gson gson =new GsonBuilder().setPrettyPrinting().create();

    static public <T> String SingleToJson(T t){
        return gson.toJson(t);
    }

    static public <T> T SingleFromJson(String json, T type){
       return (T) gson.fromJson(json, type.getClass());
    }

    static public <T> String CollectionToJson(List<T> t){
        return gson.toJson(t);
    }

    static public <T> List<T> CollectionFromJson(String json, List<T> t){
        return gson.fromJson(json,t.getClass());
    }


}
