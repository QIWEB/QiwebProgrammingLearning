package com.qiweb.Java集合类Set_List_Map_Queue使用场景梳理;

import java.util.*;

public class LinkedHashSetTest
{
    public static void main(String[] args) 
    {
        LinkedHashSet books = new LinkedHashSet();
        books.add("Java");
        books.add("LittleHann");
        System.out.println(books);

        //删除 Java
      books.remove("Java");
        //重新添加 Java
        books.add("Java");

        System.out.println(books);
    }
}