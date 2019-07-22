package xyz.somersames.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import xyz.somersames.constant.JPSConstant;

/**
 * @author szh
 * @create 2019-05-09 0:26
 **/
@Document(collection = JPSConstant.JPS)
@Data
public class JpsDto {

    /**
     * mongoId
     */
    @Id
    private String id;

    /**
     * 进程号
     */
    private String pid;

    /**
     * Java程序
     */
    private String javaProgramName;

    /**
     * 主函数路径(-l)
     */
    private String mainFunctionName;

    /**
     * JVM参数
     */
    private String jvmArgs;

    /**
     * 应用包名
     */
    private String packageName;

}
