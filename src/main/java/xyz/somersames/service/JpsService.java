package xyz.somersames.service;

import xyz.somersames.dto.JpsDto;

/**
 * @author szh
 * @create 2019-05-09 0:20
 **/
public interface JpsService {
    /**
     * 将JPS命令的数据保存至Mongo
     * @param jps
     * @return
     */
    Boolean save(JpsDto jps);
}
