package xyz.somersames.config.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import xyz.somersames.constant.JPSConstant;
import xyz.somersames.dto.JpsDto;

import java.util.List;

/**
 * @author szh
 * @create 2019-05-09 0:17
 **/
@Service
@Slf4j
public class JpsRepositoryImpl {

    @Autowired
    MongoOperations mongoOperations;

    public Page<JpsDto> queryAll(Query query, Pageable pageable){
        Assert.notNull(query,"query must be not null");
        List<JpsDto> jpsList = mongoOperations.find(query,JpsDto.class, JPSConstant.JPS);
        long totalCount = mongoOperations.count(query, JpsDto.class, JPSConstant.JPS);
        return PageableExecutionUtils.getPage(jpsList, pageable, () -> totalCount);

    }

}
