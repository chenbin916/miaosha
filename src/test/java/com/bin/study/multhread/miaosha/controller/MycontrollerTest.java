package com.bin.study.multhread.miaosha.controller;

import com.bin.study.multhread.miaosha.MyApplication;
import com.bin.study.multhread.miaosha.service.MiaoshaService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
class MycontrollerTest {

    long timed =0l;

    @Before
    public  void start () {
        System.out.println("开始测试");
    }

    @After
    public  void end () {
        System.out.println("测试耗时："+ (System.currentTimeMillis()-timed));
    }

    @Autowired
    MiaoshaService miaoshaService;

    @Test
    void miaosha_Stree_Test() {
       //模拟请求数量
        final int threadNum=23;
        //倒计数器 ，用于模拟高并发信号枪机制）
        CountDownLatch cdl =new CountDownLatch(threadNum);
       // Thread [] threads=new Thread[threadNum];
        String userid="tommy";
        Thread thread=null;
        for(int i=0;i<threadNum;i++)
        {



            thread =new Thread(()->{
                cdl.countDown();
                try {
                    //等待cld值为0，也即其他线程开始运行。
                    cdl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ;
                System.out.println("invoke..222..."+miaoshaService.miaosha("bike",(userid)));


            });
          //  threads[i]=thread;
            thread.start();;
        }

        System.out.println("test------over");
    }
}