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

    private Double S0C;

    private Double S1C;

    private Double S0U;

    private Double S1U;

    private Double EC;

    private Double EU;

    private Double OC;

    private Double OU;

    private Double MC;

    private Double MU;

    private Double CCSC;

    private Double CCSU;

    private Double YGC;

    private Double YGCT;

    private Double FGC;

    private Double FGCT;

    private Double GCT;

}
