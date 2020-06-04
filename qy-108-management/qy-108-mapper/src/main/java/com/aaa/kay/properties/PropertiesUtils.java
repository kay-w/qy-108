package com.aaa.kay.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName PropertiesUtils
 * @Description:
 * @Author 59983
 * @Date 2020/6/1
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PropertiesUtils implements Serializable   {
    private String primary;

    private Map<String,DBProperties> dynamic= new LinkedHashMap();
}
