import org.omg.CORBA.Current;

/**
 * @Description: 提供一个生产者（Producer）线程类，生产随机大写字符压入到堆栈
 * @Author: gwj
 * @CreateDate: 2019/4/27 22:09
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/27 22:09
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Producer implements Runnable {
    private PraticeThread<Character> praticeThread;

    public Producer(PraticeThread<Character> praticeThread) {
        this.praticeThread = praticeThread;
    }

    //成员内部类

    @Override
    public void run() {
        while (true) {
            char c = (char) (Math.random() * 25 + 65);
            praticeThread.push(c);
            System.out.println(Thread.currentThread().getName() + "压入" + c);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }//如果注释掉该段，则会导致线程调度由jvm决定压栈可能不会立刻执行，使得弹出与压栈出现错误
        }
    }

    /**
     * 产生随机字符
     *
     * @param
     * @return
     * @author gwj
     * @date 2019/4/27
     */
    public char randomStr() {
        char randChar = (char) (Math.random() * 25 + 65);
        return randChar;
    }

}


