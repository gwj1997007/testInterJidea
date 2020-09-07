import javax.swing.*;
import java.io.*;
import java.util.HashMap;

/**
 * @Description: 创建一个窗口
 * 比如这次使用这个窗口，导致窗口被移动到了右下角。 关闭这个窗口，下一次再启动的时候，就会自动出现在右下角。
 * <p>
 * 思路提示：
 * 启动一个线程，每个100毫秒读取当前的位置信息，保存在文件中，比如location.txt文件。
 * 启动的时候，从这个文件中读取位置信息，如果是空的，就使用默认位置，如果不是空的，就把位置信息设置在窗口上。
 * 读取位置信息的办法： f.getX() 读取横坐标信息，f.getY()读取纵坐标信息。
 * <p>
 * 注：这个练习要求使用多线程来完成。 还有另一个思路来完成，就是使用监听器，因为刚开始学习GUI，还没有掌握监听器的
 * 使用，所以暂时使用多线程来完成这个功能。
 * @Author: gwj
 * @CreateDate: 2019/4/29 15:05
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/29 15:05
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class gui {

    public static void main(String[] args) {

        String path = "J:\\location.txt";
        //定义文件
        File file = new File(path);
        //判空
        if (!file.exists())
            try {
                file.createNewFile();//---------------创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        //再次打开窗口时将读取的位置设置为窗口的位置
        HashMap<String, Integer> point = readLocation(file);
        System.out.println(point.get("x") + ',' + point.get("y"));


        //----------------------以下为Jframe------------------------------------
        //窗体主题
        //创建窗体对象
        JFrame win = new JFrame("第一个窗口");

        //设置窗体属性
        //主窗体大小
        // 主窗体设置大小
        win.setSize(400, 300);

//        // 主窗体设置位置--------------------------
        if (point != null)
            win.setLocation(point.get("x"), point.get("y"));
        else
            win.setLocation(200, 200);

        // 主窗体中的组件设置为绝对定位
        win.setLayout(null);

        // 按钮组件
        JButton b = new JButton("一键秒对方基地挂");

        // 同时设置组件的大小和位置
        b.setBounds(50, 50, 280, 30);

        // 把按钮加入到主窗体中
        win.add(b);

        // 关闭窗体的时候，退出程序
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        win.setVisible(true);


//        //启动线程
        location location = new location(win, file);
        location.start();


    }


    //创建线程每100ms写入窗口位置
    static class location extends Thread {
        JFrame jFrame;
        File file;

        //线程构造方法
        public location(JFrame jFrame, File file) {
            this.jFrame = jFrame;
            this.file = file;
        }

        @Override
        public void run() {
            while (true) {
                //线程体内容为读取出窗口位置
                writeLocation(jFrame, file);
                try {//每100ms执行一次写操作
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 方法描述
     * 将位置每隔100ms写入文件
     * 参数位置
     *
     * @param
     * @return
     * @author gwj
     * @date 2019/4/29
     */
    //读取位置方法
    public static void writeLocation(JFrame jFrame, File destinFile) {
        //通过JFrame获取x,y---------------通过jframe对象获取属性
        int x = jFrame.getX();
        int y = jFrame.getY();

        //字符流
        try (FileWriter fileWriter = new FileWriter(destinFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            //写入
            bufferedWriter.write(x + "," + y);
            bufferedWriter.newLine();//-----------------换行
            //强行写入
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 方法描述
     * 读取坐标位置
     * 目标文件
     *
     * @param
     * @return
     * @author qqg
     * @date 2019/4/29
     */
    public static HashMap<String, Integer> readLocation(File destinFile) {
        //定义存储数组
        HashMap<String, Integer> get = new HashMap<>();
//读取位置
        try (FileReader fileReader = new FileReader(destinFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (true) {
                String lo = bufferedReader.readLine();
                //判空
                if (lo == null)
                    break;
                String[] chars = lo.split(",");
                get.put("x", Integer.valueOf(chars[0]));
                get.put("y", Integer.valueOf(chars[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //取map中的值，为最后窗口所在的位置
        return get;

    }

    /**
     * 方法描述 创建文件
     * null
     *
     * @param
     * @return
     * @author qqg
     * @date 2019/4/29
     */
    public static File produceFile() {
        String path = "J:\\location.txt";
        //定义文件
        File file = new File(path);
        //判空
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("存在文件");
        }
        if (!file.isFile())
            System.out.println("不是文件");
        return file;
    }
}
