import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/5/1 18:26
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/1 18:26
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AndroidClient {
    public static void main(String[] args) throws IOException {
        //创建客户端绑定端口
        Socket client = new Socket(InetAddress.getLocalHost(), 7777);
        //获取Socket的outStream流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        //发送信息，输入流由键盘进入
        //用处理流Buffer处理system.in节点流,用到转换流将节点流转为字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        while (true) {
            //得到键盘输入的信息
            Scanner in = new Scanner(System.in);
            System.out.println("请输入：");
            String get = in.nextLine();
            //传出信息到服务器端
            bufferedWriter.write(get + "\n");
            //强制刷新
            bufferedWriter.flush();
//            bufferedWriter.close();
            String msg=bufferedReader.readLine();
//            System.out.println(msg);
           if (null != msg) {
                System.out.println(msg);
            }

            //关闭流
//            bufferedReader.close();


            //释放
//            client.close();


        }
    }
}
