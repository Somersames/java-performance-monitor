package xyz.somersames.service;

import xyz.somersames.dto.request.MongoQueryReqDto;

import java.util.List;

/**
 * @author szh
 * @create 2019-05-09 0:20
 **/
public interface MongoService<T> {
    /**
     * 将JPS命令的数据保存至Mongo
     * @param t
     * @return
     */
    Boolean save(T t);

    List<T> query(MongoQueryReqDto reqDto);
}
