/**
 * @author:gwj
 * @date:2019/4/3
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 假设通过二叉树对如下10个随机数进行排序
 67,7,30,73,10,0,78,81,10,74
 排序的第一个步骤是把数据插入到该二叉树中
 插入基本逻辑是，小、相同的放左边，大的放右边
 1. 67 放在根节点
 2. 7 比 67小，放在67的左节点
 3. 30 比67 小，找到67的左节点7，30比7大，就放在7的右节点
 4. 73 比67大， 放在67得右节点
 5. 10 比 67小，找到67的左节点7，10比7大，找到7的右节点30，10比30小，放在30的左节点。
 ...
 ...
 9. 10比67小，找到67的左节点7，10比7大，找到7的右节点30，10比30小，找到30的左节点10，10和10一样大，放在左边

 */
public class Node {
    //左子节点
    public Node leftNode;
    //右子节点
    public Node rightNode;
    //节点值
    public Object value;

    //插入
    public void add(Object v){
        //如果当前节点没有值，就把数据放在当前节点上（当前节点指的是树的根）
        if (null==value)
            value=v;
        //如果当前节点有值，就进行判断，新增的值与当前值进行判断大小关系
        else{
            //新增的值，比当前值小或相同
            if((Integer)v-((Integer)value)<=0){
                if (null==leftNode)
                    leftNode=new Node();
                leftNode.add(v);
            }
            //新增的值，比当前值大
            else{
                if (null==rightNode)
                    rightNode=new Node();
                rightNode.add(v);
            }
        }
}
    //中序遍历,返回一个容器
    public List<Object> midIter(){
        //创建一个容器存储值
        List<Object> s= new ArrayList<Object>();
        //根据取值顺序，左根右
        if(null!=leftNode){
            s.addAll(leftNode.midIter());//容器的addall方法只能添加另一个容器
            //leftNode是一个Node对象，调用自身的midIter方法，返回一个装有左节点所有值的一个容器
        }
        //中间
        s.add(value);
        //右边
        if(null!=rightNode){
            s.addAll(rightNode.midIter());
        }
        return s;
    }



    public static void main(String[] args) {
        int ra[] =new int[]{12,34,67,22,12,67,89,38};
        Node roots= new Node();
        for (int num:ra){
            roots.add(num);
        }
        System.out.println(roots.midIter());
    }
}
