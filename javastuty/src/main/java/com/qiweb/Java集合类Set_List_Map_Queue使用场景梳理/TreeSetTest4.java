package com.qiweb.Java集合类Set_List_Map_Queue使用场景梳理;

import java.util.*;

class M
{
    int age;
    public M(int age)
    {
        this.age = age;
    }
    public String toString()
    {
        return "M[age:" + age + "]";
    }
}

public class TreeSetTest4
{
    public static void main(String[] args) 
    {
        TreeSet ts = new TreeSet(new Comparator()
        {
            //根据M对象的age属性来决定大小
            public int compare(Object o1, Object o2)
            {
                M m1 = (M)o1;
                M m2 = (M)o2;
                return m1.age > m2.age ? -1
                    : m1.age < m2.age ? 1 : 0;
            }
        });    
        ts.add(new M(5));
        ts.add(new M(-3));
        ts.add(new M(9));
        ts.add(new M(-1));
        ts.add(new M(2));
        System.out.println(ts);
    }
}