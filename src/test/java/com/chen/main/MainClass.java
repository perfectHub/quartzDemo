package com.chen.main;

import com.chen.threadTest.MyRunable;
import com.chen.threadTest.ThreadDemo_2;

/**
 * @Package com.chen.main
 * @Author chenh
 * @CreateDao 2016/12/1
 * @Description
 * @Version 1.0
 */
public class MainClass {

    public static void p(Object o){
        System.out.println(o);
    }

    public static void main(String[] args){
//        ThreadDemo_2 t = new ThreadDemo_2();
//        t.start();
//        p("运行结束！");
        Runnable r = new MyRunable();
        new Thread(r).start();

        p("end");
    }
}
