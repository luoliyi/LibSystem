package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JSONUtil {
    /**
     * 序列化成json
     * */
    public static String toJson(Object obj) {
        // 对象映射器
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        String result = null;
        // 序列化user对象为json字符串
        try {
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 反序列化成对象
     * */
    public static <T> T toObject(String json,Class<T> valueType) {
        //对象映射器
        ObjectMapper mapper=new ObjectMapper();
        T result=null;
        try {
            result=mapper.readValue(json,valueType);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
