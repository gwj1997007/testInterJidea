/**
 * @author:gwj
 * @date:2019/4/10
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 把练习-支持泛型的二叉树改造成 支持泛型 <T extends Comparable>，并在比较的时候使用compare方法
 */
public class GenericTree2<T extends Comparable<T>> {
    //左子树
    public GenericTree2<T> left;
    //右子树
    public GenericTree2<T> right;
    //创建根节点
    public T value;

    //创建添加方法
    public void add(T v){
        //判空
        if (v==null){
            System.out.println("请添加值：");
        }else {
            //判断根节点空
            if (value==null){
                value=v;
            }else {
                //判断大小,调用插入对象实现的Comparable接口中的方法
                if (v.compareTo(value)>=0){
                    //如果比根节点值大则添加到左子树
                    //判断左子树空
                    if (left==null)
                        left=new GenericTree2<T>();
                    left.add(v);
                }else{
                    //插入的值比根节点的值小，放到右子树
                    //右子树判空
                    if (right==null)
                        right=new GenericTree2<>();
                    right.add(v);
                }
            }
        }
    }

    //中序遍历，返回值为list
    public List<T> iterator(){
        //创建容器存放遍历的值
        List<T> list =new ArrayList<>();
        //左中右的顺序
        //判断根节点空
        if (value==null)
            return null;
        else {//左子树判空
            if (left!=null)
                list.addAll(left.iterator());

            //中
                list.add(value);

            //右子树判空
            if (right!=null)
                list.addAll(right.iterator());

        }
        return list;
    }

    public static void main(String[] args) {
        //向二叉树插值，值的类型必须实现了Comparable接口
        GenericTree2<Integer> col=new GenericTree2<>();
        for (int i=0;i<10;i++) {
            col.add((int)(Math.random()*10));
        }
        System.out.println("中序遍历结果："+ col.iterator());

    }
}
