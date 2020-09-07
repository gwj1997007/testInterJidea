import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author:gwj
 * @date:2019/4/15
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

/**
 * 一般说来操作系统都会安装在C盘，所以会有一个 C:\WINDOWS目录。

 遍历这个目录下所有的文件(不用遍历子目录)

 找出这些文件里，最大的和最小(非0)的那个文件，打印出他们的文件名

 注: 最小的文件不能是0长度
 */
public class file {
    public static void main(String[] args) {
//        File f = new File("c:\\windows");
//        File[] fs = f.listFiles();
//        if(null==fs)
//            return;
//        long minSize = Integer.MAX_VALUE;
//        long maxSize = 0;
//        File minFile = null;
//        File maxFile = null;
//        for (File file : fs) {
//            if(file.isDirectory())
//                continue;
//            if(file.length()>maxSize){
//                maxSize = file.length();
//                maxFile = file;
//            }
//            if(file.length()!=0 && file.length()<minSize){
//                minSize = file.length();
//                minFile = file;
//            }
//        }
//        System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());
//        System.out.printf("最小的文件是%s，其大小是%,d字节%n",minFile.getAbsoluteFile(),minFile.length());
        File file = new File("c:\\windows");
         iter(file);
    }

    public static void iter (File file) {

        //获取所有文件
        File[] files = file.listFiles();
        //判空-----
        if (null == files)
            return;

        //定义两个值存放最大文件与最小文件,因为文件的大小由长度决定所以定义两个变量存放长度---
        long maxsize = 0;
        long minsize = Integer.MAX_VALUE;
        File Max = null;
        File Min = null;


        //如果是文件夹则再查找
        for (File f : files) {
            if (f.isDirectory())
                iter(f);//如果是文件夹则递归

            if (f.length()>maxsize) {
                //此处maxsize变换，重新赋值
                maxsize=f.length();//-----
                Max = f;
            }
            if ( f.length()!=0 && f.length()<minsize) {
                minsize=f.length();
                Min = f;
            }
        }

        System.out.println("max:"+Max);
        System.out.println("min:"+Min);
    }


}
