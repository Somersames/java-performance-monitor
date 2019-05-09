package xyz.somersames.core.cmdimpl;

import org.springframework.stereotype.Service;
import xyz.somersames.core.CmdExec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author szh
 * @create 2019-05-09 23:54
 **/
@Service()
public class CommonCmdExec implements CmdExec {

    public String execute(String type, String... args) {
        return null;
    }

    /**
     * 执行命令，并且把结果返回
     * @param cmd
     * @return
     */
    public String execute(String cmd) {
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
}
