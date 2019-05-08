package xyz.somersames.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.somersames.BaseTest;
import xyz.somersames.dto.JpsDto;
import xyz.somersames.service.JpsService;

import static org.junit.Assert.*;

public class JpsServiceImplTest extends BaseTest{

    @Autowired
    JpsService jpsService;

    @Test
    public void save() {
        JpsDto jpsDto =new JpsDto();
        jpsDto.setId("11");
        jpsDto.setPid("111");
        jpsService.save(jpsDto);
    }
}