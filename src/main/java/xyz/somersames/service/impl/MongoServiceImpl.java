package xyz.somersames.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.somersames.config.repository.JStatRepository;
import xyz.somersames.config.repository.JpsRepository;
import xyz.somersames.dto.JpsDto;
import xyz.somersames.dto.JstatDto;
import xyz.somersames.service.MongoService;

/**
 * @author szh
 * @create 2019-05-09 0:21
 **/
@Service
@Slf4j
public class MongoServiceImpl implements MongoService {

    @Autowired
    JpsRepository jpsRepository;

    @Autowired
    JStatRepository jStatRepository;

    public Boolean save(JpsDto jpsDto) {
        jpsRepository.save(jpsDto);
        return true;
    }

    public Boolean save(JstatDto jstatDto) {
        jStatRepository.save(jstatDto);
        return true;
    }
}
