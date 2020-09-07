/**
 * @author:gwj
 * @date:2019/4/18
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.io.*;

/**
 * 要求
 * 第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，
 * 然后转换为两个数字。
 * 注： 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就
 * 是3115，读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。
 * <p>
 * 第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连
 * 续读取两个数字
 */
public class dataStream {
    public static void main(String[] args) {
        bufferStream();
    }

    /**
     * 第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，
     * 然后转换为两个数字。
     * 注： 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就
     * 是3115，读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。
     */
    //边写边读用缓存流要用flush
    public static void bufferStream() {
        //定义要写数据到那个文件
        File file = new File("d:/destin.txt");
        //定义字符流在定义缓存流
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter writer1 = new BufferedWriter(writer);FileReader reader = new FileReader(file);
             BufferedReader reader1 = new BufferedReader(reader)) {
            //定义要写入的内容
            String col = "12,34";
            //写入
            writer1.write(col);
            writer1.flush();
            while (true) {
                //读取
                String re = reader1.readLine();
                //判空
                if (re == null)
                    break;

                System.out.println("读取结果：" + re + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (FileReader reader = new FileReader(file);
//             BufferedReader reader1 = new BufferedReader(reader)) {
//            while (true) {
//                //读取
//                String re = reader1.readLine();
//                //判空
//                if (re == null)
//                    break;
//
//                System.out.println("读取结果：" + re + "\n");
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
