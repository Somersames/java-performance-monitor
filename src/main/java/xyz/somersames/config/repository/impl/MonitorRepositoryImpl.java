package xyz.somersames.config.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @create 2019-05-09 0:17
 **/
@Service
@Slf4j
public class MonitorRepositoryImpl {

    @Autowired
    MongoOperations mongoOperations;



}
