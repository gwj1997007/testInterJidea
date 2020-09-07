import java.io.*;
import java.util.ArrayList;

/**
 * @author:gwj
 * @date:2019/4/19
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class ioPratice {
    public static void main(String[] args) {
        File srcFile = new File("d:/test");
        File destFile = new File("d:/heo");

//        copyFile(srcFile, destFile);
//        copyFolder(srcFile, destFile);
        File find=new File("J:\\javadaima");
        search(new File("J:\\javadaima"),"Magic");
    }

    /**
     * 复制文件是常见的IO操作，设计如下方法，实现复制源文件srcFile到目标文件destFile
     */
    public static void copyFile(File srcFile, File destFile) {
        //拷贝：读写的过程,1.可以边读边写，2.也可以读完再写（需要中间介质存储读取的值）
        //读取目标文件
        //选择字符流，缓存流
        //定义中间介质
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader fileReader = new FileReader(srcFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(destFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            //按行读取
            while (true) {
                String result = bufferedReader.readLine();
                //判空
                if (result == null)
                    break;
                stringBuffer.append(result + "\n");//读取的内容会聚集在一行所以加个换行符
            }
            //写
            bufferedWriter.write(String.valueOf(stringBuffer));
//强制流
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 复制文件夹,实现如下方法，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
     */
    public static void copyFolder(File srcFolder, File desFolder) {

        //定义写目标文件
        File dest = null;
        //先判断原文件和目标文件存在？
        if (!srcFolder.exists())
            return;
        if (!srcFolder.isDirectory())
            return;
        //不存在则创建
        if (!desFolder.exists())
            desFolder.mkdirs();


        //读写
        //判断文件夹
        if (srcFolder.isDirectory()) {
            //获取文件夹中的内容
            File[] list = srcFolder.listFiles();
            //遍历文件内容如果还有文件夹，则递归
            for (File item : list
                    ) {
                //是文件夹拆文件夹
                if (item.isDirectory()) {
                    dest = new File(desFolder, item.getName());//---------------
                    copyFolder(item, dest);//递归：（一层层的剥取到需要的类型）如果是文件夹递归时只会到这一步，起到拆文件夹直到文件的作用
                } else {
                    //不是文件夹，调用复制方法
                    dest = new File(desFolder, item.getName());//目标文件加上子目录
                    System.out.println(dest.getAbsolutePath());
                    //准备复制，调用方法
                    copyFile(item, dest);
                }
            }
        }
    }

    /**
     * public static void search(File folder, String search);
     * <p>
     * <p>
     * 假设你的项目目录是 e:/project，遍历这个目录下所有的java文件（包括子文件夹），找出文件内容包括 Magic的那些文件，并打印出来。
     */
    public static void search(File folder, String search) {
        //参数判断
        if (!folder.exists())
            return;
        //存放符合条件的文件
        ArrayList<File> coll = new ArrayList();
        if (folder.isDirectory()) {
            //获取文件夹内容
            File[] list = folder.listFiles();
            //遍历
            for (File item : list
                    ) {
                //如果是文件夹则递归
                if (item.isDirectory()) {
                    search(item, search);//递归：剥皮到可用条件
                } else {
                    //是文件，查找方法
                    String col = read(item);
                    //判断读取的内容由要找的值？
                    if (col.contains(search)) {
                        coll.add(item);
                    }

                }
            }
        }
        for (File i : coll
                ) {
            System.out.println(i.getName());
        }

    }

    //查找方法
    public static String read(File file) {
        //设置存放读取的内容
        StringBuffer stringBuffer = new StringBuffer();
        //判断参数
        if (file == null)
            return null;
        //输入流，字符流,缓存流
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            //读取
            while (true) {
                String result = bufferedReader.readLine();
                //判空
                if (result == null)
                    break;
                //存放到指定容器
                stringBuffer.append(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuffer);
    }
}
