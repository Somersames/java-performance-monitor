package xyz.somersames.core;

import xyz.somersames.core.cmdimpl.CommonCmdExec;

/**
 * @author szh
 * @create 2019-05-09 23:52
 **/
public class CmdFactory {
    // TODO 以后做集群或者分布式判断
    public static CmdExec getCmdInstance(){
        return new CommonCmdExec();
    }
}
