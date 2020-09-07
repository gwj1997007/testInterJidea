import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author:gwj
 * @date:2019/4/18
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class encode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        read();
    }
    /**
     * 字节流方式读取文件中的内容
     * 在转换到指定编码格式
     */
    public static void read() throws UnsupportedEncodingException {
        //定义要读取的文件对象
        File file=new File("d://hh.txt");
        //定义读取文件内容的数组
        byte[] col= new byte[(int) file.length()];
        //定义字节输入流
        try (FileInputStream inputStream = new FileInputStream(file)) {
            //读取
            inputStream.read(col);
            for (byte item:col
                 ) {
                System.out.println(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //保存格式为ANSI
        String coll=new String(col,"UTF-8");
        System.out.println(coll);
    }
}
