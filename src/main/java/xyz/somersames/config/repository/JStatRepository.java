package xyz.somersames.config.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.somersames.dto.JstatDto;

public interface JStatRepository extends MongoRepository<JstatDto,String> {
}
