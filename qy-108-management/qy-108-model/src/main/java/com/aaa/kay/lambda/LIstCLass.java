package com.aaa.kay.lambda;

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
    public static List<Product> fileterProductByColor(List<Product> list,MyPredicate<Product> mp){
        List prods = new ArrayList();
        for (Product prod:list){
            if (mp.test(prod)){
                prods.add(prod);
            }
        }
        return prods;

    }
   /* public static List<Product> filterProductByColor(List<Product> list){
        List<Product> prods = new ArrayList();
        for (Product product:list){
            if ("红色".equals(product.getColor())){
                prods.add(product);
            }
        }
        System.out.println(prods);
        return prods;
    }*/
    /*public  List<Product>  filterProductByPrice(List<Product> list){
        List<Product> prods = new ArrayList();
        for (Product product : list){
            if (product.getPrice() < 8000){
                prods.add(product);
            }
        }
        return prods;
    }
*/

    public static void main(String[] args) {
        ArrayList<Product> arrayList = new ArrayList();
        Product product = new Product();
        product.setColor("红色").setId(1).setName("sss").setPrice(500L);
        Product product1 = new Product();
        product1.setColor("蓝色").setId(2).setName("555").setPrice(80000L);
        arrayList.add(product);
        arrayList.add(product1);
        System.out.println(arrayList);
        /*fileterProductByColor(arrayList);
        System.out.println(products);*/
    }


}
