package xyz.somersames.config.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.somersames.dto.JpsDto;


/**
 * @author szh
 * @create 2019-05-09 0:16
 **/

public interface JpsRepository extends MongoRepository<JpsDto,String> {
}
