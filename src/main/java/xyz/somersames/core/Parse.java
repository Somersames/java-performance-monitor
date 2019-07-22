package xyz.somersames.core;

import java.util.Map;

/**
 * @author szh
 * @create 2019-05-09 23:47
 **/
public interface Parse<T> {

    /**
     * 根据不同的类进行解析
     * @param t
     * @return
     */
    T parse(T t,String str);


    Map parse(String str);
}