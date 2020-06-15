package com.aaa.kay.lambda;

/**
 * @ClassName ColorPredicate
 * @Description: TODO
 * @Author 59983
 * @Date 2020/6/15
 * @Version V1.0
 **/
public class ColorPredicate implements MyPredicate<Product> {
    private static final String RED="红色";

    @Override
    public boolean test(Product product) {
        return RED.equals(product.getColor());
    }
}
