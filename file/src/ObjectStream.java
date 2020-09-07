import java.io.*;

/**
 * @author:gwj
 * @date:2019/4/18
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class ObjectStream {
    public static void main(String[] args) {
ObjectStream();
    }
    /**
     * 准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组

     然后把该数组序列化到一个文件heros.lol

     接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样
     */
    public static void ObjectStream(){
//准备长度为十的hero数组
        Hero[] heros=new Hero[10];
        //初始化
        for (int i=0;i<heros.length;i++){
            heros[i]=new Hero(12,24);
        }
        //定义写入的目标文件
        File file=new File("d:/heros.lol");
        //序列化：对象以流的方式写到文件
        //创建字节流，再创建对象流
        try (FileOutputStream  outputStream= new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
             FileInputStream inputStream=new FileInputStream(file);
             ObjectInputStream objectInputStream=new ObjectInputStream(inputStream)
             ) {
//写
                objectOutputStream.writeObject(heros);
//读
           Hero[] heroes= (Hero[]) objectInputStream.readObject();

           //遍历读取的内容
            for (Hero i:heroes
                 ) {
                System.out.println(i.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
