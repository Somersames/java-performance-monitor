package xyz.somersames.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import sun.tools.jstat.Jstat;
import xyz.somersames.constant.JPSConstant;
import xyz.somersames.constant.JSTATConstant;
import xyz.somersames.core.Parse;
import xyz.somersames.core.parseImpl.JPSParse;
import xyz.somersames.core.parseImpl.JStatParse;
import xyz.somersames.dto.JstatDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author szh
 * @create 2019-05-07 0:19
 **/
@Component
public class CmdExec<T> {

    public String cmdExec(String cmd, Parse parse,T t){

        StringBuffer sb =new StringBuffer();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line =null;
            while ((line = bufferedReader.readLine()) != null) {
                parse.parse(line,t);
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CmdExec<JstatDto> instance = new CmdExec();
//        JPSParse jpsParse = new JPSParse();
        JStatParse jStatParse = new JStatParse();
        Map<String,Object> map = new HashMap<String, Object>();
        JstatDto jstatDto = new JstatDto();
        instance.cmdExec(JSTATConstant.JSTAT + " " + JSTATConstant._GC + " " +"641",jStatParse,jstatDto);
//        instance.cmdExec(JPSConstant.JPS + " " + JPSConstant._L,jpsParse,map);
        System.out.println(map);
    }

}
