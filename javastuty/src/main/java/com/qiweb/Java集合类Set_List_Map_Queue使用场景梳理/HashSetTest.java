package com.qiweb.Java集合类Set_List_Map_Queue使用场景梳理;

import java.util.*;

//类A的equals方法总是返回true,但没有重写其hashCode()方法。不能保证当前对象是HashSet中的唯一对象
class A
{
    public boolean equals(Object obj)
    {
        return true;
    }
}

//类B的hashCode()方法总是返回1,但没有重写其equals()方法。不能保证当前对象是HashSet中的唯一对象
class B
{
    public int hashCode()
    {
        return 1;
    }
}

//类C的hashCode()方法总是返回2,且有重写其equals()方法
class C
{
    public int hashCode()
    {
        return 2;
    }
    public boolean equals(Object obj)
    {
        return true;
    }
}
public class HashSetTest
{
    public static void main(String[] args) 
    {
        //元素不能重复
        HashSet books = new HashSet();
        //分别向books集合中添加两个A对象，两个B对象，两个C对象
        books.add(new A());
        books.add(new A());

        books.add(new B());
        books.add(new B());

        books.add(new C());
        books.add(new C());
        books.add("sss");
        books.add("sss");
        books.add("sss");
        books.add("sss");
        System.out.println(books.size());
    }
}