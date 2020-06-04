/*
package com.aaa.kay.annotation;

import java.lang.annotation.*;

*/
/**
 * @ClassName TDS
 * @Description: 切换数据源的注解 也就说被这个注解标识的方法活着累可以使用这个注解所制定的数据源
 *                  @Inherited 这个注解的作用是在类的继承情况下才会体现 一般有三种情况
 *                  1 当类被继承的时候 如果父类中如果使用了TDS注解 则子类也会默认自动的携带TDS
 *                        @TDS
 *  *                  public class BaseService{
 *  *
 *  *                  }
 *  *
 *  *                  public class UserService extends BaseService {
 *  *
 *  *                  }
 *  *                  相当于UserService上也会带这个TDS注解
 *               2 当接口出现继承的时候该注解不会生效
 *               3 当某一个 接口被实现的时候 最终@Inherited也不会生效
 *               只有当前类 或者某个带注解的子类才有效
 * @Author 59983
 * @Date 2020/6/1
 * @Version V1.0
 **//*


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TDS {

    String value() default "mysql";
}
*/
