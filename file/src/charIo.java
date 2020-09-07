/**
 * @author:gwj
 * @date:2019/4/18
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

import java.io.*;

/**
 * 字符流
 */
public class charIo {
    public static void main(String[] args) {

encodeFile(new File("d:/hh.txt"),new File("d:/ee.txt"));
    }

    /**
     * 准备一个文本文件(非二进制)，其中包含ASCII码的字符和中文字符。
     设计一个方法

     public static void encodeFile(File encodingFile, File encodedFile);


     在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
     加密算法：
     数字：
     如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
     如果是9的数字，变成0
     字母字符：
     如果是非z字符，向右移动一个，比如d变成e, G变成H
     如果是z，z->a, Z-A。
     字符需要保留大小写
     非字母字符
     比如',&^ 保留不变，中文也保留不变
     建议： 使用以前学习的练习题中的某个Java文件，比如循环练习，就有很多的字符和数字
     */
    public static void encodeFile(File encodingFile, File encodedFile){
        //读取目标文件
        //创建存储读取的内容
        char[] col=new char[(int) encodingFile.length()];
        //创建输入流
        //使用try with resource
        try (FileReader Reader = new FileReader(encodingFile);
             FileWriter writer=new FileWriter(encodedFile)) {

            Reader.read(col);
            System.out.println("未加密：");
            for (char i:col
                 ) {
                System.out.println(i);
            }
            //遍历文件内容开始加密
            for (int i = 0; i < col.length; i++) {

                //加密操作
//                如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
//                如果是9的数字，变成0
                System.out.println("是数字:"+Character.isDigit(col[i]));
                if (Character.isDigit(col[i])){
                    System.out.println("位操作："+col[i]);
                    System.out.println("是9?:"+(col[i]=='9'));
                    if (col[i]!='9') {
                        col[i] += 1;
                    }
                    else{
                        col[i]='0';
                    } System.out.println("操作后："+col[i]+"\n");

                }
//                如果是非z字符，向右移动一个，比如d变成e, G变成H
//                如果是z，z->a, Z-A。
//                字符需要保留大小写
                else if (Character.isLetter(col[i])){
                    if (col[i]!='z') {
                        col[i] += 1;
                    }
                    else{
                        if (col[i]=='z')
                            col[i]='a';
                        if (col[i]=='Z')
                            col[i]='A';
                    }
                }
            }
            System.out.println("加密后：");
            for (char item:col
                    ) {
                System.out.println(item);
            }
            //加密操作结束，开始写到目标文件
            writer.write(col);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
