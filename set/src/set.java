/**
 * @author:gwj
 * @date:2019/4/4
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 在比较字符串章节，有一个同样的练习
 * 创建一个长度是100的字符串数组
 * 使用长度是2的随机字符填充该字符串数组
 * 统计这个字符串数组里重复的字符串有多少种
 * 使用HashSet来解决这个问题
 */
public class set {
    //产生长度为length的数组
    public static char[] RandomString(int length) {
        //创建数组
        char[] chars = new char[length];
        short start = '0';
        short end = 'z';
        //充满数组
        for (int i = 0; i < chars.length; i++) {
            //产生随机字符
            while (true) {//如果第一个不是合法字符，则在进行一次循环
                char s = (char) (Math.random() * ((end - start) + start));
                //判断是否是合法字符
                if (Character.isDigit(s) || Character.isLetter(s)) {
                    chars[i] = s;
                    break;
                }
            }
        }
        return chars;
    }
    //初始化长度为100的字符串数组
    public static String[] full(int length){
        //定义字符串数组
        String[] strings=new String[length];
        for (int i=0;i<strings.length;i++){
            strings[i]=new String(RandomString(2));
        }
        return strings;
    }
    //
    public static void check(){
        String[] ss=full(1000);
        //创建hashset
        HashSet<String> hs =new HashSet<>();
        //将字符串数组加到hashset中
        for (String s:ss
             ) {
            hs.add(s);
        }
        //创建Arraylist
        List<String> list=new ArrayList<>();
        for (String s1:ss
             ) {
            list.add(s1);
        }
        list.removeAll(hs);
        HashSet<String> newhs =new HashSet<>();
        for (String s2:list
             ) {
            newhs.add(s2);
            System.out.println("去掉重复的"+s2);
        }
        int count=0;
        for (String s3:ss
             ) {
            count++;
            System.out.print(" "+s3);
            if (count%10==0)
                System.out.println();
        }
        System.out.println("重复的字符串个数为："+newhs.size());
    }

    public static void main(String[] args) {
        check();
    }
}
