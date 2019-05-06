package xyz.somersames.util;

import xyz.somersames.constant.JPSConstant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author szh
 * @create 2019-05-07 0:19
 **/
public class CmdExec {
    public static String cmdExec(String cmd){

        StringBuffer sb =new StringBuffer();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmd);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line =null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void main(String[] args) {
       String result = CmdExec.cmdExec(JPSConstant.JPS);
       System.out.println(result);
    }
}
