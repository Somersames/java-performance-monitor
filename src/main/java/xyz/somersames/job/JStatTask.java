package xyz.somersames.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import xyz.somersames.constant.JPSConstant;
import xyz.somersames.core.parseImpl.JPSParse;
import xyz.somersames.util.CmdExec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 首先获取当前运行环境的所有ID，然后通过Jstat再次获取其他详细信息
 */

@EnableScheduling
@Component
@Slf4j
public class JStatTask {

    @Autowired
    CmdExec cmdExec;

    @Autowired
    JPSParse jpsParse;

    private ExecutorService executorService = new ThreadPoolExecutor(4,4,0L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());


    public void start(){
        // 获取到ID后再获取详情
        List<String> idList = getCurrentId();
    }

    private List<String> getCurrentId(){
        String cmd = JPSConstant.JPS + " " + JPSConstant._Q;
        Map<String,Object> map = new HashMap<String, Object>();
        cmdExec.cmdExec(cmd,jpsParse,map);
        return new ArrayList<String>(map.keySet());
    }

    public static void main(String[] args) {
        new JStatTask().start();
    }
}
