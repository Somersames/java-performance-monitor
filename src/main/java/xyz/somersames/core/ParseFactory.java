package xyz.somersames.core;

import org.apache.commons.lang3.StringUtils;
import xyz.somersames.constant.JPSConstant;
import xyz.somersames.core.parseImpl.JPSParse;

/**
 * @author szh
 * @create 2019-05-09 23:52
 **/
public class ParseFactory {
    public static Parse getParseInstance(String cmd){
        if(StringUtils.isNotBlank(cmd)){
            if(cmd.startsWith(JPSConstant.JPS)){
                return new JPSParse();
            }
        }
        return null;
    }
}
