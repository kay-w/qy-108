package com.aaa.kay.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName Map2BeanUtils
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/13
 * @Version V1.0
 **/
public class Map2BeanUtils {
    private Map2BeanUtils(){}
    //使用高性能的java实例化工具
    private final static Objenesis OBJENESIS = new ObjenesisStd(true);
    // StringBuffer 线程安全 StringBUilder 线程不安全
    private final static StringBuffer STRING_BUFFER = new StringBuffer();
    // 使用mappper 集合作用本地缓存池来使用 保证线程安全ConcurrentHashMap线程安全
    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP=
            new ConcurrentHashMap<Class, MethodAccess>();
    public static <T> T map2Bean(Map<String,Object> map,Class<T> clazz) {
        // 通过clazz类型获取泛型对象 获取咱们需要的对象 但是这个对象是一个空对象
        T instance = OBJENESIS.newInstance(clazz);
        MethodAccess methodAccess = CONCURRENT_HASH_MAP.get(clazz);
        if (null == methodAccess) {
            methodAccess = MethodAccess.get(clazz);
            /**
             * map 中是以key value存在的
             * map.put("usrname", )
             * map .put key 一样 就覆盖了
             * 如果用map.putIfAbsent 如果key存在就不会存放
             */
            CONCURRENT_HASH_MAP.putIfAbsent(clazz, methodAccess);
        }
        // 循环数据
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            // 于是就可以获取到Map中的各种数据 然后就需要setter方法进行赋值了
            String setMethodName = setMethodName(entry.getKey());
            int index = methodAccess.getIndex(setMethodName, entry.getValue().getClass());
            methodAccess.invoke(instance, index, entry.getValue());
        }
        return instance;
    }

    /**
     * @MethodName: 通过字段获取set的方法名
     * @Description:
     * @Param: [fieldName]
     * @Return: java.lang.String
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    private static String setMethodName (String fieldName){
        // fieldName bookName getBookName()
        // 所以第一步不是直接获取 而是把这个字段的首字母大写
        String fieldJava = firstToUpperCase(fieldName);
        STRING_BUFFER.setLength(0);//覆盖所有数据 长度为0
        // 拼接set方法
        return STRING_BUFFER.append("set").append(fieldJava).toString();
    }
    /**
     * @MethodName: 封装String首字母大写
     * @Description:
     * @Param: [field]
     * @Return: java.lang.String
     * @Author: 59983
     * @Date: 2020/5/13
    **/
    private static String firstToUpperCase(String field){
        return field.substring(0,1).toUpperCase()+field.substring(1);
    }
}
