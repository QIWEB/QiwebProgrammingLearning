package com.qiweb.Java集合类Set_List_Map_Queue使用场景梳理;

import java.util.*;

public class IdentityHashMapTest
{
    public static void main(String[] args) 
    {
        IdentityHashMap ihm = new IdentityHashMap();
        //下面两行代码将会向IdentityHashMap对象中添加两个key-value对
        ihm.put(new String("语文") , 89);
        ihm.put(new String("语文") , 78);

        //下面两行代码只会向IdentityHashMap对象中添加一个key-value对
        ihm.put("java" , 93);
        ihm.put("java" , 98);
        System.out.println(ihm);
    }
}