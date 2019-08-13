package xyz.somersames.config.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.util.Assert;
import xyz.somersames.constant.JSTATConstant;
import xyz.somersames.dto.JstatDto;

import java.util.List;

public class JStatRepositoryImpl {
    @Autowired
    MongoOperations mongoOperations;

    public Page<JstatDto> queryAll(Query query, Pageable pageable){
        Assert.notNull(query,"query must be not null");
        List<JstatDto> jstatList = mongoOperations.find(query,JstatDto.class, JSTATConstant.JSTAT);
        long totalCount = mongoOperations.count(query, JstatDto.class, JSTATConstant.JSTAT);
        return PageableExecutionUtils.getPage(jstatList, pageable, () -> totalCount);

    }
}
