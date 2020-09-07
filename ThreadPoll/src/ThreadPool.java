import java.util.LinkedList;

/**
 * @Description: 在 练习-同步查找文件内容 ，如果文件特别多，就会创建很多的线程。 改写这个练习，使用线程池的方式来完成。
 * <p>
 * 初始化一个大小是10的线程池
 * @Author: gwj
 * @CreateDate: 2019/4/28 12:42
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/28 12:42
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadPool {
    //线程容器
    LinkedList<Runnable> pool = new LinkedList<>();
    //定义容器/线程池大小
    int PoolSize;

    //构造方法
    public ThreadPool() {
        PoolSize = 10;
        //初始化线程
        for (int i = 0; i < PoolSize; i++) {
            //空线程
            new bodyThread("线程池线程" + i).start();
        }
    }

    //添加方法
    public void add(Runnable r) {
        //同步对象监视器
        synchronized (pool) {
            pool.add(r);
            //添加完通知其他
            pool.notifyAll();
        }
    }

    //空线程
    class bodyThread extends Thread {
        String name;

        public bodyThread(String name) {
            this.name = name;
        }
        Runnable a;
        @Override
        public void run() {
            //线程任务，执行待执行的任务
            //判断容器是否为空
            System.out.println("启动： " + this.getName());
            while (true) {//while?

                synchronized (pool) {
                    while (pool.isEmpty()) {
                        try {
                            pool.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //不为空则取出
                    a = pool.removeLast();
                    //通知
                    pool.notifyAll();//注意通知的对象为线程同步监视器
                }
                System.out.println(this.getName() + " 获取到任务，并执行");
                //执行待执行的任务
                a.run();
            }
        }
    }
}
