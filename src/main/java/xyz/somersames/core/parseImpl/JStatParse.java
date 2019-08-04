package xyz.somersames.core.parseImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import xyz.somersames.core.Parse;
import xyz.somersames.dto.JstatDto;

import java.util.Map;

@Service
public class JStatParse implements Parse<JstatDto> {
    public void parse(String line,JstatDto jstatDto) {
        if(StringUtils.isNotBlank(line) && line.trim().startsWith("S0C")){
            // 默认跳过
            return;
        }
        String[] strs = line.split("\\s+");
        if(strs != null && strs.length !=0){
            jstatDto.setS0C(convertStrToDouble(strs[0]));
            jstatDto.setS1C(convertStrToDouble(strs[1]));
            jstatDto.setS0U(convertStrToDouble(strs[2]));
            jstatDto.setS1U(convertStrToDouble(strs[3]));
            jstatDto.setEC(convertStrToDouble(strs[4]));
            jstatDto.setEU(convertStrToDouble(strs[5]));
            jstatDto.setOC(convertStrToDouble(strs[6]));
            jstatDto.setOU(convertStrToDouble(strs[7]));
            jstatDto.setMC(convertStrToDouble(strs[8]));
            jstatDto.setMU(convertStrToDouble(strs[9]));
            jstatDto.setCCSC(convertStrToDouble(strs[10]));
            jstatDto.setCCSU(convertStrToDouble(strs[11]));
            jstatDto.setYGC(convertStrToDouble(strs[12]));
            jstatDto.setYGCT(convertStrToDouble(strs[13]));
            jstatDto.setFGC(convertStrToDouble(strs[14]));
            jstatDto.setFGCT(convertStrToDouble(strs[15]));
            jstatDto.setGCT(convertStrToDouble(strs[16]));
        }
    }

    public void parse(String line, Map<String, Object> map) {
        if(StringUtils.isNotBlank(line) && line.startsWith("S0C")){
            // 默认跳过
            return;
        }
        String[] strs = line.split(" ");
        if(strs != null && strs.length !=0){

        }
    }

    private Double convertStrToDouble(String str){
        if(StringUtils.isNotBlank(str)){
            return Double.parseDouble(str);
        }
        return 0.0;
    }
}
