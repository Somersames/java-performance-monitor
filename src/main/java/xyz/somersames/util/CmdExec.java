package xyz.somersames.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import xyz.somersames.constant.JPSConstant;
import xyz.somersames.core.Parse;
import xyz.somersames.core.parseImpl.JPSParse;

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
public class CmdExec {

    public String cmdExec(String cmd, Parse parse, Map<String,Object> map){

        StringBuffer sb =new StringBuffer();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line =null;
            while ((line = bufferedReader.readLine()) != null) {
                parse.parse(line,map);
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CmdExec instance = new CmdExec();
        JPSParse jpsParse = new JPSParse();
        Map<String,Object> map = new HashMap<String, Object>();
        instance.cmdExec(JPSConstant.JPS + " " + JPSConstant._L,jpsParse,map);
        System.out.println(map);
    }

}
