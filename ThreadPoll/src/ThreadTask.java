import java.io.*;

/**
 * @Description: 遍历所有文件，当遍历到文件是.java的时候，创建一个查找文件内容Magic的任务，
 * 把这个任务扔进线程池去执行，继续遍历下一个文件
 * @Author: gwj
 * @CreateDate: 2019/4/28 14:20
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/28 14:20
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadTask {
    public static void main(String[] args) {

        //定义路径
        String path = "J:\\hello";
        //定义目标文件
        File destFile = new File(path);
        Iterator(destFile,"magic");


    }
    //创建线程池
    static ThreadPool pool = new ThreadPool();//?static


    //遍历文件
    public static void Iterator(File destFile, String key) {
        //判空
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        if (destFile.isDirectory()) {
            File[] list = destFile.listFiles();
            //遍历文件
            for (File item : list
                    ) {//如果是文件夹，则递归
                if (item.isDirectory())
                    Iterator(item, key);
                //不是文件夹则查找以.java结尾的文件
                //获取名字
                String name = item.getName();
                if (name.endsWith(".java")) {
                    //创建查找文件的线程任务
                    Thread s = new Thread() {
                        @Override
                        public void run() {
                            //查找文件内容
                            readFile(item, key);
                        }
                    };
                    //添加任务到线程池
                    pool.add(s);
                }
            }
        }

    }

//    class readThread extends Thread{
//        File file;
//        String key;
//
//        public readThread(File file, String key) {
//            this.file = file;
//            this.key = key;
//        }
//
//
//        public void run(File file,String key) {
//            readFile(file, key);
//        }
//    }
//

    //查找方法
    public static void readFile(File file, String key) {

        //字符流
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (true) {
                //按行读取
                String col = bufferedReader.readLine();
                //判空
                if (col==null)
                    break;
                //判断是否含有所找关键字
                if (col.contains(key)) {
                    //输出文件名
                    System.out.printf( "线程: %s 找到子目标字符串%s,在文件:%s%n",Thread.currentThread().getName(), key,file);
                    //并中止
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
