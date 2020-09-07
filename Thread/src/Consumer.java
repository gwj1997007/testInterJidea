/**
 * @Description: 提供一个消费者（Consumer）线程类，从堆栈中弹出字符并打印到控制台
 * @Author: gwj
 * @CreateDate: 2019/4/28 11:51
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/28 11:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Consumer implements Runnable {
    //构造方法
    private PraticeThread<Character> praticeThread;

    public Consumer(PraticeThread<Character> praticeThread) {
        this.praticeThread = praticeThread;
    }

    @Override
    public void run() {
        while (true) {
            char c = praticeThread.pull();
            System.out.println(Thread.currentThread().getName()+"弹出：" + c);
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
