/**
 * @author:gwj
 * @date:2019/4/7
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * 首先初始化一个List,长度是10，值是0-9。
 然后不断的shuffle，直到前3位出现
 3 1 4

 shuffle 1000,000 次，统计出现的概率
 */
public class collections {
    public static void main(String[] args) {
    System.out.println(probability()+"%");
    }
    //创建方法
    public static double probability(){
        ArrayList<Integer> col= new ArrayList<>();
        //初始化
        for (int i=0;i<10;i++){
            col.add(i);
        }
        int count=0;
        //乱序
        for (int i=0;i<100000;i++) {
            Collections.shuffle(col);
            if (3==col.get(0)&&1==col.get(1)&&4==col.get(2))
                count++;
        }
        return count/100.;
    }
}
