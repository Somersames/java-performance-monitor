package xyz.somersames.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import xyz.somersames.constant.JPSConstant;

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

    public String cmdExec(String cmd, Map<String, String> map){

        StringBuffer sb =new StringBuffer();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line =null;
            while ((line = bufferedReader.readLine()) != null) {
                handlePid(map,line);
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
        String result = instance.cmdExec(JPSConstant.JPS + ' ' + JPSConstant._M + ' ' + JPSConstant._V,new HashMap<String, String>());
    }

    private void handlePid(Map<String,String> map, String line){
        if(StringUtils.isNotBlank(line)){
            int pid = line.indexOf(" ");
            if(pid < line.length()){
                map.put(line.substring(0,pid),line.substring(pid + 1));
            }
        }
    }
}
