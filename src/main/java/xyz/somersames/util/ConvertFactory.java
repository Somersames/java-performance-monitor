package xyz.somersames.util;

public interface ConvertFactory<T> {

    void convert(String suffix, String value, T t);
}
