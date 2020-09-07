import java.util.ArrayList;

/**
 * @author:gwj
 * @date:2019/4/4
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class MaoPao {
    //排序
    public static int[] maopao(int[] list) {
        //双层循环
        int midle = 0;
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j + 1] < list[j]) {
                    midle = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = midle;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 10 + 10);
            System.out.println(num[i]);
        }
        System.out.println("*****************");

        int[] ll = maopao(num);
        for (int i = 0; i < ll.length; i++) {
            System.out.println(ll[i]);
        }
    }

}
