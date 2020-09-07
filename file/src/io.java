import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author:gwj
 * @date:2019/4/15
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class io {
    public static void main(String[] args) {
//inputStream();
//
//        writeByByte();
//        readByByte();
//        split();
        merge();
    }

    //创建输入流
    public static void inputStream() {
        //创建文件
        File f = new File("d:/hh.txt");//绝对路径
        /* 从虚拟机到存储设备上，输出流 */
        try {
            FileOutputStream out = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //读取数据：以字节流的形式，前提：需要知道该文件的路径
    public static void readByByte() {
        //创建文件对象
        File f = new File("d:/hh.doc");//绝对路径
        //如果不存在该文件？
        //从存储介质读取内容，输入流
        try {
            FileInputStream input = new FileInputStream(f);
            //调用读方法read返回值类型byte数组
            //读取的内容为文件内容的数组形式
            //定义数组不使用对象模式
            byte[] col = new byte[(int) f.length()];//文件的长度为f.length
            try {
                input.read(col);//输出为对应的ascii码
                for (byte item : col
                        ) {
                    System.out.println(item);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //写数据

    /**
     * OutputStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
     * FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据
     * <p>
     * 注: 如果文件d:/lol2.txt不存在，写出操作会自动创建该文件。
     * 但是如果是文件 d:/xyz/lol2.txt，而目录xyz又不存在，会抛出异常
     */
    public static void writeByByte() {
        //创建文件对象
        File f = new File("d:/hh.txt");
        //选择字符流还是字节流
        //写到存储介质上
        FileOutputStream w = null;
        try {
            w = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //定义一个写入数据的byte数组
        byte[] input = {88, 89};
        //调用write方法
        try {
            w.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拆分文件：
     * 找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
     * 比如文件 eclipse.exe，大小是309k。
     * 拆分之后，成为
     * eclipse.exe-0
     * eclipse.exe-1
     * eclipse.exe-2
     * eclipse.exe-3
     * 思路：读目标文件内容
     * 读取指定大小后，将数据写到新文件
     * 以此类推
     * 存在三个问题：
     * 要拆分的文件大小为空
     * 拆分个数：按指定大小拆分的文件最后一个不够指定大小
     * 最后一个文件的截取范围：最后一个文件与前边的文件截取范围不同
     */
    public static void split() {
        //创建要读取的文件对象
        File sourceFile = new File("D:/java/eclipse/eclipse.exe");//要读取的文件的路径，绝对路径
        //创建字节输入流
        FileInputStream input = null;
        try {
            input = new FileInputStream(sourceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建存储读取数据的字节流数组
        byte[] col = new byte[(int) sourceFile.length()];
        try {
            input.read(col);
            input.close();//----注意用完后要关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }

        //现在col中已经存储了目标文件的内容
        //现在以指定的大小创建文件，并将数据写到文件中
//数组转换为字符串

        //因为是byte数组，所以最好用数组工具Arrays
//        String cols=new String(col);
        byte[] d;

        //拆分文件的个数-----
        int fileNum = 0;
        if (0 == col.length % 102400)
            fileNum = col.length / 102400;
        else {
            fileNum = col.length / 102400 + 1;
        }


        for (int j = 0; j < fileNum; j++) {
            //判断是否是最后一个文件,因为最后一个文件有可能大小达不到指定大小
            if (j < fileNum - 1)//-------
                d = Arrays.copyOfRange(col, j * 102400, (j + 1) * 102400);
            else {
                d = Arrays.copyOfRange(col, j * 102400, col.length);
            }
            /* 写 */


            File w = new File("d:/a.doc" + -j);
            FileOutputStream wr = null;
            try {
                wr = new FileOutputStream(w);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                wr.write(d);
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 把上述拆分出来的文件，合并成一个原文件。
     * <p>
     * 以是否能正常运行，验证合并是否正确
     * 边读边写
     * 将要写入的目标文件放在最外边
     */
    public static void merge() {

        //获取以a.doc-为名的文件的个数
        //遍历文件
        //获取遍历文件的目录
        File aimt = new File("d:/");
        //获取文件列表
        File[] files = aimt.listFiles();//返回值为文件数组
        //定义输入字节流
        FileInputStream inputStream = null;
        //定义写入字节流
        FileOutputStream outputStream = null;
        //定义字符串存储文件名
        String name = "";
        //定义byte数组存储读取的内容
        byte[] col;
        //写入目标文件
        File destin = new File("d:/zz.exe");
        try {
            outputStream = new FileOutputStream(destin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (File item : files
                ) {
            if (item.isFile() && item.getName().startsWith("a") && item.getName().contains(".doc")) {
//获取要读取的目标文件名

                name = item.getAbsolutePath();
                //要读取的文件
                File file = new File(name);
                try {
                    inputStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                col = new byte[(int) file.length()];
                //将内容读取到col数组
                try {
                    inputStream.read(col);
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //将读取的内容写到目标文件
                try {
                    outputStream.write(col);
                    //强制输出流
                    outputStream.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }//循环外关闭流
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
