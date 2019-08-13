package xyz.somersames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.somersames.dto.request.MongoQueryReqDto;
import xyz.somersames.job.JpsTask;

@RestController
@RequestMapping(value = "api")
public class JpsController {

    @Autowired
    JpsTask jpsTask;

    @GetMapping("start")
    public String startJps(@RequestBody MongoQueryReqDto reqDto){
        jpsTask.start();
        return "OK";
    }
}
