package xyz.somersames.core.parseImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import xyz.somersames.core.Parse;
import xyz.somersames.dto.JpsDto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author szh
 * @create 2019-05-09 23:50
 **/
@Service
public class JPSParse implements Parse<Map<String,Object>>{

    public void parse(String str,JpsDto jpsDto) {
        return;
    }

    public void parse(String line, Map<String,Object> map) {
        if (StringUtils.isNotBlank(line)) {
            int pid = line.indexOf(" ");
            if (pid < line.length() && pid > 0) {
                map.put(line.substring(0, pid), line.substring(pid + 1));
            } else {
                map.put(line,"");
            }
        }
    }
}
