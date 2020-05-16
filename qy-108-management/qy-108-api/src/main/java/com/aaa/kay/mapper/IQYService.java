package com.aaa.kay.mapper;

import com.aaa.kay.model.User;
import com.aaa.kay.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassName IQYService
 * @Description: fallbackFactory 就是来实现熔断的 在开发阶段不开启熔断 开启熔断不会抛异常
 *          spring一旦用feign来进行传递单数是  简单类型用@Requestparam 可以有多个 只能有一个刨床来兴
 *          而且要使用@RequestBody 也就是说把这些参数值传递到provider的controller中在provider中也必须也一样 最好赋值
 *
 * @Author 59983
 * @Date 2020/5/16
 * @Version V1.0
 **/
@FeignClient(value = "system-interface")
public interface IQYService {
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);
}
