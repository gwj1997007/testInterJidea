import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 首先获取 获取本机IP地址，比如说是192.168.2.100。 那么本网段的ip地址就是从 192.168.2.1 到 192.168.2.255
 * 再通过使用java 执行ping命令 判断这些ip地址能否使用，把能够使用的ip打印出来
 * @Author: gwj
 * @CreateDate: 2019/4/29 19:36
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/29 19:36
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 * //使用Runtime.getRuntime.exec("")执行windows的exe*****************
 * //能ping通加入容器
 */
public class hostIp {
    public static void main(String[] args) {
        //获取本机ip地址
        try {
            InetAddress ip = InetAddress.getLocalHost();//DESKTOP-PNL6HJC/192.168.11.2
            //获取本机ip地址
            String host = ip.getHostAddress();//192.168.11.2
            //获取网段
            String first = host.substring(0, host.lastIndexOf("."));//192.168.11
            System.out.println("本机ip:" + host);
            System.out.println("网段" + first);

            //定义容器存放能ping通的ip地址
            List<String> col = Collections.synchronizedList(new ArrayList<>());//------------------
            //定义存放已ping的ip数
            AtomicInteger number = new AtomicInteger();//？？？？
            //创建线程池
            //构造方法摘要
            //ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
            ThreadPoolExecutor threadPoolExecutor =
                    new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());//-----------
            //从1-255挨个执行判断能否ping通
            for (int i = 0; i < 255; i++) {
                //利用线程池创建多线程执行防止ping是受阻
                //创建匿名线程并添加到线程池
                String ips = first + "." + (0+i);
                threadPoolExecutor.execute(new Runnable(){
                    @Override
                    public void run() {
                        //要ping的ip
                        System.out.println(ips);
                        if (reachable(ips))
                            col.add(ips);//能ping通就加到容器
                        synchronized (number) {//--------为什么要锁
                            System.out.println("已经完成:" + number.incrementAndGet() + " 个 ip 测试");
                        }
                    }
                });
            }
            //执行结束，关闭线程池
            threadPoolExecutor.shutdown();//---------
            //等待线程池关闭，但是最多等待1个小时
            if (threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("如下ip地址可以连接");
                for (String theip : col) {
                    System.out.println(theip);
                }
                System.out.println("总共有:" + col.size() + " 个地址");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法描述
     * 判断地址能否ping通
     *
     * @param ip
     * @return
     * @author gwj
     * @date 2019/5/1
     */
    public static Boolean reachable(String ip) {
        boolean flag = false;
        //定义存储读取的内容
        StringBuilder stringBuilder = new StringBuilder();
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("ping " + ip);//---------------------
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ping通后会返回程序数据，通过输入流获取p执行后得到的结果
        //创建输入流，用缓存处理流包裹
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        //读取
        while (true) {
            //判空
            try {
                if (null == bufferedReader.readLine())
                    break;
                //获取内容
                stringBuilder.append(bufferedReader.readLine()+ "\r\n");//----------------
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedReader.close();//-----------------------
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断是否成功
        System.out.println(stringBuilder.toString());
        if (stringBuilder.toString().contains("TTL"))
            flag = true;

        return flag;
    }
}
