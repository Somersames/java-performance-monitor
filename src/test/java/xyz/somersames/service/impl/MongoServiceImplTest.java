package xyz.somersames.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.somersames.BaseTest;
import xyz.somersames.dto.JpsDto;
import xyz.somersames.service.MongoService;

public class MongoServiceImplTest extends BaseTest{

    @Autowired
    MongoService mongoService;

    @Test
    public void save() {
        JpsDto jpsDto =new JpsDto();
        jpsDto.setId("11");
        jpsDto.setPid("111");
        mongoService.save(jpsDto);
    }
}