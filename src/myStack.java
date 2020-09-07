import java.util.LinkedList;

/**
 * @author:gwj
 * @date:2019/4/3
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

/**
 * 模仿栈
 * 在尾部添加，从尾部获取
 */
public class myStack implements stack {
    LinkedList<Hero> push =new LinkedList<>();
    //压栈
    @Override
    public void push(Hero h) {
        push.add(h);
    }
//去除
    @Override
    public Hero pull() {
        return push.removeLast();
    }

    @Override
    public Hero peek() {

        return push.getLast();
    }

    //测试mystack
    public static void main(String[] args) {
        //创建栈，并初始化
        myStack ms = new myStack();
        for (int i=0;i<5;i++){
            System.out.println("压入hero"+i);
            ms.push(new Hero("name"+i));
        }

        for (int i=0;i<5;i++){
            System.out.println("弹出hero"+ms.pull().name);
        }
    }
}
