/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/4/27 21:58
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/27 21:58
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 方法描述
 * 生产者消费者问题是一个非常典型性的线程交互的问题。
 * <p>
 * 1. 使用栈来存放数据
 * 1.1 把栈改造为支持线程安全
 * 1.2 把栈的边界操作进行处理，当栈里的数据是0的时候，访问pull的线程就会等待。 当栈里的数据是200的时候，访问push的线程就会等待
 * 2. 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
 * 3. 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
 * 4. 提供一个测试类，使两个生产者和三个消费者线程同时运行，结果类似如下 ：
 */
public class PraticeThread<T> {
    LinkedList<T> list = new LinkedList<>();


    public synchronized void push(T item) {
        //设置旗帜
        while (list.size() >= 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } //通知
        this.notifyAll();
        //操作
        list.addLast(item);

    }


    public synchronized T pull() {
        //旗帜
        while (list.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } //通知
        this.notifyAll();
        return list.removeLast();

    }


    public synchronized T peek() {
        return list.peek();
    }
}
