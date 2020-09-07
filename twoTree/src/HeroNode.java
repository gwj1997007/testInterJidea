/**
 * @author:gwj
 * @date:2019/4/4
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 根据上面的学习和理解，设计一个Hero二叉树，HeroNode.
 * 可以向这个英雄二叉树插入不同的Hero对象，并且按照Hero的血量倒排序。
 * <p>
 * 随机生成10个Hero对象，每个Hero对象都有不同的血量值，插入这个HeroNode后，把排序结果打印出来。
 */
//方法：中序遍历总是左中右，所以把小的值放右边
public class HeroNode {
    //创建左子节点
    public HeroNode leftNode;
    //创建右子节点
    public HeroNode rightNode;
    //创建根节点
    public Hero value;

    //插入(对象方法)静态方法不能引用静态变量？
    public void add(Hero h) {
        //判断根节点为空
        if (value == null) {
            value = h;
        }//如果根节点有值则放入左右子节点
        else {//判断血量
            //如果血量小于根节点则放在右节点上
            if (h.blood <= value.blood) {
                if (rightNode == null) {//创建一个HeroNode对象
                    HeroNode right = new HeroNode();
                    right.add(h);
                }
            } else {
                //如果血量大于根节点放在左子树上
                if (leftNode == null)
                    leftNode = new HeroNode();//直接调用属性中创建的leftNode省空间
                leftNode.add(h);
            }
        }
    }

    //遍历,返回值为一个容器
    public List<Hero> midItera() {
        //创建一个容器存值
        List<Hero> collect = new ArrayList<Hero>();
        //按照中序遍历
        //取左子树值
        if (leftNode != null) {
            collect.addAll(leftNode.midItera());
        }
        //取中间的值
        collect.add(value);
        //取右子树的值
        if (rightNode != null) {
            collect.addAll(rightNode.midItera());
        }
        return collect;
    }


    //测试
    public static void main(String[] args) {
        List<Hero> coll = new ArrayList<>();
        //初始化英雄添加到二叉树上
        for (int i = 0; i < 10; i++) {
            coll.add(new Hero("aa", (double) i + 1));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("未加入到二叉树上时：" + coll.get(i).blood);
        }

        //创建二叉树
        HeroNode co = new HeroNode();
        //将值加入二叉树
        for (int i = 0; i < coll.size(); i++) {
            co.add(coll.get(i));
        }
        //遍历
        List<Hero> blod = new ArrayList<>();
        blod = co.midItera();
        for (int i = 0; i < blod.size(); i++) {
            System.out.println(blod.get(i).blood);
        }
    }

}