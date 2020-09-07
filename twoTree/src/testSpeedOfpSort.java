import java.util.HashMap;
import java.util.Map;

/**
 * @author:gwj
 * @date:2019/4/4
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class testSpeedOfpSort {
    public static void main(String[] args) {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 1000);
            System.out.println("未排序前：" + nums[i]);
        }
        System.out.println("*******************************");

        MaoPao maoPao = new MaoPao();
        long start = System.currentTimeMillis();
        int[] s = maoPao.maopao(nums);
        long end = System.currentTimeMillis();
        long time0 = (end - start);
        System.out.println("maopao耗时：" + (end - start));
        for (int a : s) {
            System.out.println(a);
        }
        System.out.println("*********************************");
        Select select = new Select();
        long start1 = System.currentTimeMillis();
        int[] s1 = select.select(nums);
        long end1 = System.currentTimeMillis();
        long time1 = (end1 - start1);
        System.out.println("select耗时：" + (end1 - start1));
        for (int a : s1) {
            System.out.println(a);
        }
        System.out.println("*********************************");
        Node node = new Node();
        //将数组的值存入二叉树
        for (int i = 0; i < nums.length; i++) {
            node.add(nums[i]);
        }
        long start2 = System.currentTimeMillis();
        //二叉树中序遍历进行排序
        node.midIter();
        long end2 = System.currentTimeMillis();
        long time = (end2 - start2);
        System.out.println("二叉树中序遍历排序耗时：" + (end2 - start2));
        System.out.println(node.midIter());

        HashMap<String, Long> map = new HashMap<>();
        map.put("冒泡", time0);
        map.put("选择", time1);
        map.put("二叉树", time);

        //比较方法
        Node node2 = new Node();
        //将数组的值存入二叉树
        node2.add(map.values());
        System.out.println(node2.midIter());
    }
}




