package com.example.practice.testautowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 1.@Resource(name = "serviceA")找一个对象，名称（name）为serviceA的类
 * 即
 * @Service(value = "serviceA")
 * public class ServiceA
 * 2.@Autowired找对象的类名为 ServiceAutowire
 * Resource是JDK提供的，而Autowired是Spring提供的
 * Resource不允许找不到bean的情况，而Autowired允许（@Autowired(required = false)） -->但是有可能运行报错nullpoint
 * 指定name的方式不一样，@Resource(name = "baseDao"),@Autowired()@Qualifier("baseDao")
 * Resource默认通过name查找，而Autowired默认通过type查找
 *
 * 例如：
 * @Resource(name = "serviceA")   @Service(value = "serviceA")
 *
 * @Resource   @Service(value = "serviceA") 或者 @Service都可以
 */
@RestController
public class controller {

//    @Resource(name = "serviceA")
    @Resource
    //如果按照此种方法不指定name,type则系统根据字段名去匹配，然后获得value，否则根据类型ServiceResource去匹配，获取value，如果有
    //不唯一，则报
    private ServiceResource serviceA;

    @Autowired(required = false)
    private ServiceAutowire serviceAutowire;

    @RequestMapping("testResource")
    public String testResource(){
        String auto = serviceA.testResource();
        return auto;
    }

    @RequestMapping("testautowire")
    public String testautowire(){
        String auto = serviceAutowire.testautowire();
        return auto;
    }
}
