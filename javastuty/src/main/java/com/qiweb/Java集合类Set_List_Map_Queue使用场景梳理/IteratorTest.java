package com.qiweb.Java集合类Set_List_Map_Queue使用场景梳理;

import java.util.*;
//iterator实现遍历:
//从代码可以看出，iterator必须依附于Collection对象，若有一个iterator对象，必然有一个与之关联的Collection对象。
//        除了可以使用iterator接口迭代访问Collection集合里的元素之外，使用java5提供的foreach循环迭代访问集合元素更加便捷
public class IteratorTest
{
    public static void main(String[] args) 
    {
        //创建一个集合
        Collection books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        books.add("疯狂Android讲义");
        books.add(null);


        //获取books集合对应的迭代器
        Iterator it = books.iterator();
        while(it.hasNext())
        {
            //it.next()方法返回的数据类型是Object类型，
            //需要强制类型转换
            String book = (String)it.next();
            System.out.println(book);
            if ("疯狂Java讲义".equals(book))
            {
                //从集合中删除上一次next方法返回的元素
                it.remove();
            }
            //对book变量赋值，不会改变集合元素本身
            book = "测试字符串";    
        }
        System.out.println(books);
    }
}