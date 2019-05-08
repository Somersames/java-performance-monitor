package xyz.somersames.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import xyz.somersames.config.repository.MonitorRepository;
import xyz.somersames.config.repository.impl.MonitorRepositoryImpl;
import xyz.somersames.dto.JpsDto;
import xyz.somersames.service.JpsService;

/**
 * @author szh
 * @create 2019-05-09 0:21
 **/
@Service
@Slf4j
public class JpsServiceImpl implements JpsService {

    @Autowired
    MonitorRepository monitorRepository;

    public Boolean save(JpsDto jps) {
        monitorRepository.save(jps);
        return true;
    }
}
