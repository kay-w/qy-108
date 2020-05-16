package com.aaa.kay.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName SpringContextUitls
 * @Description: TODO
 * @Author 59983
 * @Date 2020/5/13
 * @Version V1.0
 **/
public class SpringContextUitls implements ApplicationContextAware {
    private SpringContextUitls(){}
    private static ApplicationContext APPLICATIONCONTEXT=null;
    private static final ReadWriteLock READ_WRITE_LOCK=new ReentrantReadWriteLock();

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATIONCONTEXT = applicationContext;
    }
    public static ApplicationContext getApplicationContext(){
        Lock lock= READ_WRITE_LOCK.readLock();
        lock.lock();
        try {
            if (null!= APPLICATIONCONTEXT){
                return APPLICATIONCONTEXT;
            }else{
                return null;
            }
        }finally {
            lock.unlock();
        }
    }
}
