package xyz.somersames.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.somersames.constant.JPSConstant;
import xyz.somersames.core.parseImpl.JPSParse;
import xyz.somersames.dto.JpsDto;
import xyz.somersames.util.CmdExec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@EnableScheduling
@Component
@Slf4j
public class JpsTask {


    private final CmdExec cmdExec;

    private final JPSParse jpsParse;


    private ExecutorService executorService = new ThreadPoolExecutor(4,4,0L,TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());

    @Autowired
    public JpsTask(JPSParse jpsParse, CmdExec cmdExec) {
        this.jpsParse = jpsParse;
        this.cmdExec = cmdExec;
    }

    private List<String> commandList = new ArrayList<String>();

    {
        commandList.add(JPSConstant._L);
        commandList.add(JPSConstant._M);
        commandList.add(JPSConstant._V);
        commandList.add(JPSConstant._Q);
    }

//    @Scheduled()
    public void start(){
        final Map<String, JpsDto> jpsMap = new ConcurrentHashMap<String, JpsDto>();
        for(final String suffix: commandList){
            executorService.execute(new Runnable() {
                final String su = suffix;
                final String command = JPSConstant.JPS + " " + su;
                final Map<String,Object> map = new HashMap<String, Object>();
                public void run() {
                    cmdExec.cmdExec(command,jpsParse,map);
                    setValue(jpsMap,map,su);
                }
            });
        }
        while(!executorService.isShutdown()){

        }
        log.info("[jps]定时任务处理结束");
    }

    private synchronized void setValue(Map<String, JpsDto> jpsMap, Map<String,Object> map,String su){
        for(String key : map.keySet()){
            JpsDto jpsDto = null;
            if(jpsMap.containsKey(key)){
                jpsDto = jpsMap.get(key);
            } else {
                jpsDto = new JpsDto();
                jpsMap.put(key,jpsDto);
            }
            convertValueToJps((String) map.get(key),jpsDto,su);
        }
    }

    // TODO 用工厂模式来建立比较好
    private void convertValueToJps(String value, JpsDto jpsDto, String su){
        if(JPSConstant._L.equals(su)){
            jpsDto.setMainFunctionName(value);
        } else if(JPSConstant._M.equals(su)){
            jpsDto.setJvmArgs(value);
        }
    }
}
