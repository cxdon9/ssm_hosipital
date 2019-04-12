package com.baizhi.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();

        //list.add("张");
        //泛型存在于编译器,运行期程序中的发型会擦出

        Class clz = Class.forName("java.util.List");

        Method me = clz.getMethod("add", Object.class);
        me.invoke(list, "张三");

        System.out.println(list);
    }
}
