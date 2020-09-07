/**
 * @author:gwj
 * @date:2019/4/4
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * 准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
 * hero-3229
 * hero-6232
 * hero-9365
 * ...
 * <p>
 * 因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
 * 要求使用两种办法来寻找
 * 1. 不使用HashMap，直接使用for循环找出来，并统计花费的时间
 * 2. 借助HashMap，找出结果，并统计花费的时间
 */
public class hashmap {
    public static void main(String[] args) {
        //创建ArrayList
        List<Hero> col = new ArrayList();
        //初始化容器
//        for (int i = 0; i <= 3000000; i++) {
//            col.add(new Hero("hero_" + (int) (Math.random() * 9000 + 1000)));
//            System.out.println("未查找前：" + col.get(i).name);
//        }

        //将名字作为键,名字对应的英雄对象们放入容器作为值
        HashMap<String, List<Hero>> list = new HashMap<>();
        for (Hero h : col) {
            //获取对应名字的英雄集合
            List<Hero> hs = list.get(h.name);
            //如果为空
            if (hs == null) {//开辟一个装载名字对应的英雄们的容器
                hs = new ArrayList<>();
                //将找到的符合条件的键值放入hashmap容器中
                list.put(h.name, hs);
            }
            //如果装载某一个姓名的容器不是空的则继续添加
            hs.add(h);
        }

//        //find
//        findByHashMap(list);
//        findByFor(col);
//        String[] s = {"a", "a", "b", "c", "c", "d", "1", "0", "1"};
//        System.out.println(solve3(s));
        HashMap<String, String> col2 = new HashMap<>();
        col2.put("adc", "物理英雄");
        col2.put("apc", "魔法英雄");
        col2.put("t", "坦克");
        System.out.println(reverse(col2));
    }

    public static void findByHashMap(HashMap<String, List<Hero>> list) {
        long start = System.currentTimeMillis();
        List<Hero> hero = list.get("hero_5555");
        long end = System.currentTimeMillis();
        if (hero != null)
            System.out.println("hashmap耗时：" + (end - start) + "ms,找到" + hero.size() + "个");
        else {
            System.out.println("不存在");
        }
    }

    public static void findByFor(List<Hero> list) {
        //创建新容器装找到的
        ArrayList<Hero> list1 = new ArrayList();
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.equals("hero-5555")) {
                list1.add(list.get(i));
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("for耗时：" + (end - start) + "ms,共有" + list1.size() + "个");


    }

    /**
     * 用hashMap
     * 将一个字符串数组中的元素做为key,出现的次数作为值
     *
     * @param strings
     */
    public static HashMap<String, Integer> solve(String[] strings) {
        //创建hashMap<出现的元素，Arraylist<int>>
        HashMap<String, Integer> result = new HashMap<>();
        //获取key,使用hashSet
        HashSet<String> key = new HashSet<>();
        //将字符串数组中的元素存放到key容器中
        for (int i = 0; i < strings.length; i++) {
            key.add(strings[i]);
        }

        //迭代器迭代set
        for (Iterator keys = key.iterator(); keys.hasNext(); ) {
            String k = (String) keys.next();
            System.out.println(k);
            int count = 0;
            for (String ss : strings) {
                //如果包含则累加
                if (k.equals(ss))
                    count++;
            }
            result.put(k, count);
        }
        return result;
    }

    //方法二：二维数组类似函数映射：值对应位置
    // 二维数组第一行存值：0对应48，1对应49，
    // 第二行存出现次数
    //key就是下标的值（对应下标位置存储的值的字符形式）
    public static HashMap<String, Integer> solve2(String[] s) {
        //定义新数组
        int[][] newItem = new int[2]['z' - '0'];
        for (String ss : s) {
            char item = ss.charAt(0);
            //将值与数组下标一一唯一对应
            //下标为0的与值为0（字符为48）的对应，下标为2的与值为2（字符为49）的对应，
            //二维数组，第一行存值，第二行计数
            newItem[0][item - '0'] = item;
            //计算出现的次数
            newItem[1][item - '0']++;
        }
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < newItem[0].length; i++) {
            //但数组中有的下标位置无值时，值为0，所以判断值不能为零
            if (newItem[0][i] != 0) {
                //注意：数字与字符间的转换0对应的字符为48
                //获取key
                char key = (char) (newItem[0][i]);
                String rkey = "" + key;
                //newItem[1][i]对应的值为newItem[0][i]中的值出现的次数
                //获取次数
                int count = newItem[1][i];
                result.put(rkey, count);
            }
        }
        return result;
    }

    //映射：值作为位置
    public static HashMap<String, Integer> solve3(String[] s) {
        HashMap<String, Integer> result = new HashMap<>();
        //定义数组作为存放位置
        int[] col = new int[122];
        //定义位置下标
        int index;
        //获取字符串数组元素
        for (String s1 : s) {
            char[] c = s1.toCharArray();
            index = c[0];//字符转换为ascii的值作为位置；
            col[index]++;//col[index]的值为其出现的次数
            char i = (char) index;
            result.put("" + i, col[index]);
        }
        return result;
    }

    /**
     * 使用如下键值对，初始化一个HashMap：
     * adc - 物理英雄
     * apc - 魔法英雄
     * t - 坦克
     * <p>
     * 对这个HashMap进行反转，key变成value,value变成key
     * 提示： keySet()可以获取所有的key, values()可以获取所有的value
     */
    public static HashMap reverse(HashMap<String, String> col) {
        //初始化HashMap
        HashMap<String, String> col2 = new HashMap<>();
        //获取col的key
        Set<String> keys = col.keySet();
        for (String key : keys
                ) {
            String value = key;
            //获取key对应的值作为新的key
            String nKey = col.get(key);
            col2.put(nKey, value);
        }
        //清空原来的col
        col.clear();
        col.putAll(col2);
        return col;
    }
}