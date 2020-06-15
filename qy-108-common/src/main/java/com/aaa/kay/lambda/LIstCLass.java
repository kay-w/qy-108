package com.aaa.kay.lambda;

import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LIstCLass
 * @Description: TODO
 * @Author 59983
 * @Date 2020/6/15
 * @Version V1.0
 **/
public class LIstCLass {
    public List<Product> filterProductByColor(List<Product> list){
        List<Product> prods = new ArrayList();
        for (Product product:list){
            if ("红色".equals(product.getColor())){
                prods.add(product);
            }
        }
        return prods;
    }

    public static void main(String[] args) {
        ArrayList<Product> arrayList = new ArrayList();
        Product product = new Product();
        product.setColor("红色");
        arrayList.add(product);
    }
}
