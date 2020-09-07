/**
 * @author:gwj
 * @date:2019/4/18
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.io.*;
import java.util.Scanner;

/**
 * 自动创建有一个属性的类文件。
 * 通过控制台，获取类名，属性名称，属性类型，根据一个模板文件，自动创建这个类文件，并且为属性提供setter和getter
 */
public class praticeCreateClass {
    public static void main(String[] args) {
        //获取输入信息
        Scanner input = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = input.nextLine();
        System.out.println("请输入属性类型：");
        String type = input.nextLine();
        System.out.println("请输入属性名：");
        String property = input.nextLine();
        //模板文件
        File file = new File("d:/temp.txt");
        //目标文件
        File file2 = new File("d:/temp2.java");

//        //模板
//        template(file);
        System.out.println(className + property + type);
        //改模板
        changeModel(file, file2, className, property, type);
    }

    /*
    制作一个文件写入类的模板样式
     */
    public static void template(File file) {
        //采用缓存流，父类为字符流
        //先创建字符流，再创建缓存流
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            //定义内容
            String col = "public class @class@ {\n" +
                    "    public @type@ @property@;\n" +
                    "    public @class@() {\n" +
                    "    }\n" +
                    "    public void set@Uproperty@(@type@  @property@){\n" +
                    "        this.@property@ = @property@;\n" +
                    "    }\n" +
                    "      \n" +
                    "    public @type@  get@Uproperty@(){\n" +
                    "        return this.@property@;\n" +
                    "    }\n" +
                    "}";
            //写入样式
            bufferedWriter.write(col);
            //强制推入缓存流
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    读取模板文件根据输入的条件更改模板内容
     */
    public static void changeModel(File file, File destin, String ClassName, String property, String type) {
        //读取内容
        StringBuffer stringBuffer = new StringBuffer();//stringbuffer需要new
        String string = "";
        //先创建字符流,再创建缓存流
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader);) {
            while (true) {
                String colum = bufferedReader.readLine();
                //判空
                if (colum == null)
                    break;
                //读取结束
                stringBuffer.append(colum + '\n');
            }

//            string = new String(stringBuffer);
            //StringBuffer具有string的一切方法，但比string更好，长度可变-------
            String Uproperty = Character.toUpperCase(stringBuffer.charAt(0)) + property.substring(1);
//            char frist = property.charAt(0);
//            String Uproperty = Character.toUpperCase(frist) + property.substring(1);
            //进行替换处理,替换不是把原字符串操作，而是复制到新的字符串中操作，所以最后要重新赋值给源字符串--------
//            stand(string,ClassName,property,type);
            string = string.replaceAll("@class@", ClassName);
            string = string.replaceAll("@type@", type);
            string = string.replaceAll("@property@", property);
            string = string.replaceAll("@Uproperty@", Uproperty);
            System.out.println(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(destin);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            //写入
            bufferedWriter.write(string);
            //强行加入流
            bufferedWriter.flush();//-------

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建替换方法
//    public static void stand(String srcString,String ClassName,String property,String type){
//        srcString.replaceAll("@class@",ClassName);
//        srcString.replaceAll("@type@",type );
//        srcString.replaceAll("@property@",property);
//    }
}
