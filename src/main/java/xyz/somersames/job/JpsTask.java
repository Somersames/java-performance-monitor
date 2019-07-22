package xyz.somersames.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import xyz.somersames.constant.JPSConstant;
import xyz.somersames.dto.JpsDto;
import xyz.somersames.util.CmdExec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableScheduling
public class JpsTask {


    @Autowired
    CmdExec cmdExec;

    private List<String> commandList = new ArrayList<String>();

    {
        commandList.add(JPSConstant.JPS + ' ' + JPSConstant._L);
        commandList.add(JPSConstant.JPS + ' ' + JPSConstant._M);
        commandList.add(JPSConstant.JPS + ' ' + JPSConstant._V);
        commandList.add(JPSConstant.JPS + ' ' + JPSConstant._Q);
    }

    @Scheduled()
    public void start(){
        Map<String, JpsDto> jpsMap = new HashMap<String, JpsDto>();
        for(String command: commandList){
            Map<String,String> map = new HashMap<String, String>();
            cmdExec.cmdExec(command,map);
        }
    }

    //TODO 存入mango是否合理呢？
    private void convertMapToJps(Map<String,String> map, JpsDto jpsDto){

    }
}
