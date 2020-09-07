/**
 * @author:gwj
 * @date:2019/4/7
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.util.LinkedHashSet;

/**
 * 利用LinkedHashSet的既不重复，又有顺序的特性，
 * 把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
 */
public class linkedHashSet {
    public static void main(String[] args) {

        sortBycharushunxu2();
    }
    public static void sortBycharushunxu(){
        LinkedHashSet<Integer> col=new LinkedHashSet<>();
        double pi=Math.PI;
        int i=0;
        while(i<100){
            int f=(int)pi%10;
            System.out.println("取到的数："+f);
            pi*=10;
            col.add(f);
            i++;
        }
        System.out.println(col);

    }
    public static void sortBycharushunxu2() {
    LinkedHashSet<Integer> col=new LinkedHashSet<>();
    //数字转字符串
        String pi=String.valueOf(Math.PI);
        //去除小数点
        pi=pi.replace(".","");//返回值为字符串
        //字符串转为数组
        char[] p=pi.toCharArray();
        for (char i:p
             ) {
            int item=Integer.parseInt(String.valueOf(i));
            col.add(item);
        }
    System.out.println(col);
    }

}
