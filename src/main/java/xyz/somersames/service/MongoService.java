package xyz.somersames.service;

import xyz.somersames.dto.JpsDto;
import xyz.somersames.dto.JstatDto;

/**
 * @author szh
 * @create 2019-05-09 0:20
 **/
public interface MongoService {
    /**
     * 将JPS命令的数据保存至Mongo
     * @param jpsDto
     * @return
     */
    Boolean save(JpsDto jpsDto);

    Boolean save(JstatDto jstatDto);
}
