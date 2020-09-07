/**
 * @Description: 测试两个线程压栈出栈
 * @Author: gwj
 * @CreateDate: 2019/4/27 22:21
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/27 22:21
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class testStack {
    public static void main(String[] args) {


        PraticeThread stack = new PraticeThread();
        //创造线程
        Producer producer = new Producer(stack);
        Consumer consumer = new Consumer(stack);
        new Thread(producer).start();
        new Thread(consumer).start();

    }
}