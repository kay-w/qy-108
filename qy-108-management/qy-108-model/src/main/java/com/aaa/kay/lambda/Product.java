package com.aaa.kay.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Product
 * @Description: TODO
 * @Author 59983
 * @Date 2020/6/15
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product {
    private String color;
    private String name;
    private int id;
    private Long price;


}
