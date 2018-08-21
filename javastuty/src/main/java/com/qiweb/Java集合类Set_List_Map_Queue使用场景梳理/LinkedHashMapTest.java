package com.qiweb.Java集合类Set_List_Map_Queue使用场景梳理;

import java.util.*;

public class LinkedHashMapTest
{
    public static void main(String[] args) 
    {
        LinkedHashMap scores = new LinkedHashMap();
        scores.put("语文" , 80);
        scores.put("英文" , 82);
        scores.put("数学" , 76);
        //遍历scores里的所有的key-value对
        for (Object key : scores.keySet())
        {
            System.out.println(key + "------>" + scores.get(key));
        }
    }
}