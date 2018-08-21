package com.qiweb.Java多线程;

/**
 * 使用匿名内部类的方式启动线程
 * Created by office on 2018/8/20.
 */
public class 匿名多线程 {
    public static  void main(String []agrs){
        new Thread("线程1")
                {
                        public void run(){
                            System.out.println(Thread.currentThread().getName() + ":" );
                        }
                }
        .start();

        System.out.println("------ 无聊的分割线 ------");

        // 实现 Runnable 接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x=0;x<100;x++){
                    System.out.println(Thread.currentThread().getName() + ":" + x);
                }
            }
        },"线程2").start();

        System.out.println("------ 无聊的分割线 ------");
        // 更有难度的
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 100; x++) {
                    System.out.println("hello" + ":" + x);
                }
            }
        }) {
            public void run() {
                for (int x = 0; x < 100; x++) {
                    System.out.println("world" + ":" + x);
                }
            }
        }.start();


    }
}
