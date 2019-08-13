package xyz.somersames.config.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.somersames.dto.JstatDto;

public interface JStatRepository extends MongoRepository<JstatDto,String> {
    Page<JstatDto> queryAll(Query query, Pageable pageable);
}
