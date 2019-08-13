package xyz.somersames.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MongoQueryReqDto {

    @JsonFormat(pattern="yyyy-MM-dd hh:ss:mm")
    private Date startTime;

    @JsonFormat(pattern="yyyy-MM-dd hh:ss:mm")
    private Date endTime;

    private Double max;

    private Double min;

    private String orderBy;

}
