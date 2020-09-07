import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:gwj
 * @date:2019/4/2
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class LinkList {
    public static void main(String[] args) {
    Queue();
    }

    //双向链表
    public static  void Deque(){
            //linkedlist是一个双向链表结构的list
            LinkedList<Hero> list = new LinkedList<>();
            //linkedList实现了Deque
            Deque<Hero> ll=new LinkedList<>();
            //加入数据
            list.add(new Hero("aa"));
            list.add(new Hero("ss"));
            list.add(new Hero("cc"));
            System.out.println(list);

            //方便在头部和尾部插入数据
            System.out.println("在头部插入数据：");
            list.addFirst(new Hero("vvv"));
            System.out.println("在尾部插入数据：");
            list.addLast(new Hero("xxx"));

            //查看最前面的
            System.out.println(list.getFirst().name);
            //查看最后面的
            System.out.println(list.getLast().name);
            //去除第一个
            System.out.println("去除第一个"+list.removeFirst().name);
            //去除最后一个
            System.out.println("去除最后一个"+list.removeLast().name);
            for (Hero h:list
                    ) {
                System.out.println(h.name);
            }
        }
    //队列
    public static void Queue(){
       //和ArrayList一样，LinkedList实现了List接口
        List ll = new LinkedList<Hero>();

        //LinkedList实现了DEque双向链表，进而实现了 Queue
        //Queue代表队列
        Queue<Hero> q=new LinkedList<Hero>();
        //依次增加
        System.out.println("初始化队列：");
        q.add(new Hero("aa"));
        q.add(new Hero("bb"));
        q.add(new Hero("cc"));
        //在最后边增加
        q.offer(new Hero("aaa"));
        q.offer(new Hero("bbb"));
        System.out.println(q);
        System.out.println("把第一个元素取poll出来：");
        Hero h =q.poll();
        System.out.println(h);
        System.out.println("取出第一个后的队列：");
        System.out.println(q);

    }
    //linkedlist实现栈stack

}
