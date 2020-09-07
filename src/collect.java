import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:gwj
 * @date:2019/4/1
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class collect {
    //list


    public static void main(String[] args) {
        //getC();
        //delet();
        deleteA();
    }

    /**
     * 测试通过syso输出list内容
     */
    public static void getC() {
        List collect = new ArrayList();
        for (int i = 0; i < 5; i++) {
            collect.add(i);
        }
        System.out.println(collect);
    }

    /**
     * 首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
     * hero 0
     * hero 1
     * hero 2
     * ...
     * hero 99.
     * <p>
     * 通过遍历的手段，删除掉名字编号是8的倍数的对象
     */
//创建方法
    public static void delet() {
        //创建集合
        List<Hero> col = new ArrayList();
        //初始化集合
        for (int i = 0; i < 100; i++) {
            col.add(new Hero("hero" + i));
        }
        for (Hero s : col
                ) {
            System.out.println(s.name);

        }
        //删除编号为8的倍数
        //将尾号是八的倍数得值放入新容器
        List<Hero> Ncol = new ArrayList<Hero>();
        for (int i = 0; i < col.size(); i += 8) {
            Ncol.add(col.get(i));
            //col.remove(i);
            //不能通过循环的方式进行删除，第二次删除时总数已经变化了
            //下标变化了
        }

        System.out.println("******************\n删除后");
        //查看数据
        col.removeAll(Ncol);
        for (Hero h : col
                ) {
            System.out.println(h.name);
        }
    }

    /**
     * 测试数组循环 删除
     */
    public static void deleteA() {
        //初始化数组
        String[] col = new String[100];
        for (int i = 0; i < col.length; i++) {
            String a =String.valueOf(i);
            col[i] = a;
        }
        //删除前
        System.out.println("删除前：");
        for (String s : col
                ) {
            System.out.println(s);
        }
        System.out.println("*****************");
        //删除后
        //将数组转换为字符串，因为要进行修改所以转换为StringBuffer
        StringBuffer Ncol = new StringBuffer(col[0]);
        Ncol.append(col);
        //删除下标为8的
        for (int i = 0; i < col.length; i += 8) {
            Ncol.delete(i, i);
        }
        System.out.println("cd"+col.length);
        for (int i = 0; i < Ncol.length(); i++) {
            System.out.println(Ncol.charAt(i));
        }

    }

}


