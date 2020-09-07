/**
 * @author:gwj
 * @date:2019/4/18
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.io.*;

/**
 * 设计一个方法，用于移除Java文件中的注释
 * <p>
 * public void removeComments(File javaFile)
 * <p>
 * <p>
 * 比如，移出以//开头的注释行
 * <p>
 * File f = new File("d:/LOLFolder/LOL.exe");
 * System.out.println("当前文件是：" +f);
 * //文件是否存在
 * System.out.println("判断是否存在："+f.exists());
 * //是否是文件夹
 * System.out.println("判断是否是文件夹："+f.isDirectory());
 */
public class BufferIo {
    public static void main(String[] args) {
        File file = new File("J:\\interPoject\\test\\file\\src\\BufferIo.java");
        removeComments(file);
    }
//边读边写，也可先读存放到Stringbuffer,再写
    public static void removeComments(File javaFile) {
        File file = new File("d:/BufferIo1.java");
        //判断文件为空
        if (!javaFile.isFile())
            return;
        //定义buffer缓存流
        //先创建字符流,再创建缓存流
        try (FileReader reader = new FileReader(javaFile);
             BufferedReader reader1 = new BufferedReader(reader);
             //写缓存流
             FileWriter writer = new FileWriter(file);
             BufferedWriter writer1 = new BufferedWriter(writer)
        ) {
            //一行一行的读取，直到最后一行
            while (true) {
                //一行读取
                String result = reader1.readLine();
                //返回值为字符
                //对字符串进行操作
                //先判段每行是不是空，再操作---------
                if (result == null)
                    break;
                //如果以//开头则不写入
                if (result.trim().startsWith("//"))
                    continue;
                writer1.write(result + '\n');
                writer1.flush();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void removeComments(File javaFile) {
//        StringBuffer sb = new StringBuffer();
//        //读取内容
//        try (FileReader fr = new FileReader(javaFile); BufferedReader br = new BufferedReader(fr);) {
//            while (true) {
//                String line = br.readLine();
//                if (null == line)
//                    break;
//                //如果不是以//开头，就保存在StringBuffer中
//                if (!line.trim().startsWith("//"))
//                    sb.append(line).append("\r\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (
//                FileWriter fw = new FileWriter("d:/dfile.java");
//                PrintWriter pw = new PrintWriter(fw);
//        ) {
//            //写出内容
//            pw.write(sb.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
