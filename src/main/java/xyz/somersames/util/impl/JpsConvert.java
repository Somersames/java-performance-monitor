package xyz.somersames.util.impl;

import org.springframework.stereotype.Component;
import xyz.somersames.constant.JPSConstant;
import xyz.somersames.dto.JpsDto;
import xyz.somersames.util.ConvertFactory;

@Component
public class JpsConvert implements ConvertFactory<JpsDto> {


    public void convert(String suffix, String value, JpsDto jpsDto) {
        if(JPSConstant._L.equals(suffix)){
            jpsDto.setMainFunctionName(value);
        } else if(JPSConstant._M.equals(suffix)){
            jpsDto.setMainMethodsArgs(value);
        } else if(JPSConstant._Q.equals(suffix)){
            // TODO
        } else if(JPSConstant._V.equals(suffix)){
            jpsDto.setJvmArgs(value);
        }
    }
}
