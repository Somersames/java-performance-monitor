package xyz.somersames.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import xyz.somersames.constant.JSTATConstant;

@Document(collection = JSTATConstant.JSTAT)
@Data
public class JstatDto {
    @Id
    private String id;

    private Long S0C;

    private Long S1C;

    private Long S0U;

    private Long S1U;

    private Long EC;

    private Long EU;

    private Long OC;

    private Long OU;

    private Long MC;

    private Long MU;

    private Long CCSC;

    private Long CCSU;

    private Long YGC;

    private Long YGCT;

    private Long FGC;

    private Long FGCT;

    private Long GCT;

}
