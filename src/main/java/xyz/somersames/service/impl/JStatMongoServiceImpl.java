package xyz.somersames.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.somersames.config.repository.JStatRepository;
import xyz.somersames.dto.JstatDto;
import xyz.somersames.dto.request.MongoQueryReqDto;
import xyz.somersames.service.MongoService;

import java.util.List;

@Service
public class JStatMongoServiceImpl implements MongoService<JstatDto> {
    @Autowired
    JStatRepository jStatRepository;

    public Boolean save(JstatDto jstatDto) {
        jStatRepository.save(jstatDto);
        return true;
    }

    public List<JstatDto> query(MongoQueryReqDto reqDto) {
        return null;
    }
}
