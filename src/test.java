/**
 * @author:gwj
 * @date:2019/3/31
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class test {
    //双指针法,i（慢）,j（快）
    //下标为i的和下标为j的进行对比，每找到一个不同的，慢指针加一上一位
    public static void main(String[] args) {
        int[] s = {1, 1, 3, 3, 4, 4};
        System.out.println(removeDuplicates2(s));

    }

    public static int removeDuplicates(int[] nums) {
        //定义指针j;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //判断值是否相等
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        for (int n = 0; n < nums.length; n++) {
            System.out.println(nums[n]);
        }
        return i + 1;//i为最后调整后的数组最后一个数的下标，返回的为数组长度所以要加1
    }


    //方法二：容器
    public static int removeDuplicates2(int[] nums) {
        //创建容器存放数组中的数
        List<Integer> collect = new ArrayList<>();
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //判断容器中是否存在
            if (!collect.contains(nums[i])) {
                //如果不存在，则加入到容器中
                collect.add(nums[i]);
            }
        }
        int[] b=new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            b[i] = collect.get(i);
            nums[i]=b[i];
            System.out.println(nums[i]);
        }

        return collect.size();
    }
}
