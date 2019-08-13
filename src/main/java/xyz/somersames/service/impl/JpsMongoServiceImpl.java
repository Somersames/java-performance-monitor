package xyz.somersames.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.somersames.config.repository.JpsRepository;
import xyz.somersames.dto.JpsDto;
import xyz.somersames.dto.request.MongoQueryReqDto;
import xyz.somersames.service.MongoService;

import java.util.List;

@Service
public class JpsMongoServiceImpl implements MongoService<JpsDto> {

    @Autowired
    JpsRepository jpsRepository;

    public Boolean save(JpsDto jpsDto) {
        jpsRepository.save(jpsDto);
        return true;
    }

    public List<JpsDto> query(MongoQueryReqDto reqDto) {
        return null;
    }

}
