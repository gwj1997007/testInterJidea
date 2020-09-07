/**
 * @author:gwj
 * @date:2019/4/8
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 支持泛型的二叉树
 */
//节点的值的类型不定，所以用泛型
public class GenericTree<T> {//T为节点存储值的类型
    public GenericTree<T> left;
    public GenericTree<T> right;
    public T value;

    //创建add方法
    public void add(T v) {
        //判空
        if (v == null) {
            System.out.println("请输入内容：");
        } else {
            //如果根节点无值
            if (value == null) {
                value = v;
            } else {
                //如果数值大于根节点放左边
                if ((Integer) v <= (Integer) value) {
                    if (left == null)
                        left = new GenericTree<T>();
                    left.add(v);//用括号括起来时，添加就只添加了部分

                } else {
                    if (right == null)
                        right = new GenericTree<T>();
                    right.add(v);//注意

                }
            }
        }
    }

    //中序遍历
    public List<T> midelIter() {
        //创建list装在内容
        List<T> col = new ArrayList<>();
        //如果左边为空
        if (left != null)
            col.addAll(left.midelIter());//注意

        col.add(value);

        if (right != null)
            col.addAll(right.midelIter());


        return col;
    }

    public static void main(String[] args) {

        int randoms[] = new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};

        GenericTree<Integer> roots = new GenericTree<>();
        for (int number : randoms) {
            roots.add(number);
        }

        System.out.println(roots.midelIter());

    }
}
