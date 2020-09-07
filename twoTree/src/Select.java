/**
 * @author:gwj
 * @date:2019/4/4
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class Select {
    //选择排序
    public static int[] select(int[] num) {
        int swap = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[j] < num[i]) {
                    swap = num[i];
                    num[i] = num[j];
                    num[j] = swap;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 10 + 10);
            System.out.println(num[i]);
        }
        System.out.println("*****************");

        int[] ll =select(num);
        for (int i = 0; i < ll.length; i++) {
            System.out.println(ll[i]);
        }
    }
}
