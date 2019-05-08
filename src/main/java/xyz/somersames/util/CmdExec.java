package xyz.somersames.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
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

public class CmdExec {


    Map<String,String> jps =new HashMap<String, String>();

    public String cmdExec(String cmd){

        StringBuffer sb =new StringBuffer();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line =null;
            while ((line = bufferedReader.readLine()) != null) {
                handlePid(jps,line);
                 sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        CmdExec instance =new CmdExec();
       String result = instance.cmdExec(JPSConstant.JPS);
       System.out.println(result);
    }

    private void handlePid(Map<String,String> map, String line){
        if(StringUtils.isNotBlank(line)){
            String[] pids = line.split(" ");
            int len =pids.length;
            if(len >= 2){
                map.put(pids[0],pids[1]);
            }
        }
    }
}
