package xyz.somersames.config.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.somersames.dto.JpsDto;


/**
 * @author szh
 * @create 2019-05-09 0:16
 **/

public interface JpsRepository extends MongoRepository<JpsDto,String> {
    Page<JpsDto> queryAll(Query query, Pageable pageable);
}
