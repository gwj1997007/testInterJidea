import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/5/1 16:30
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/1 16:30
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        //服务器端监听端口
        ServerSocket server =new ServerSocket(8888);
        //接受客户端来的信息
        Socket s = server.accept();
        System.out.println(s);
        //通信
        //用公有管道Socket对象
        //接收数据,已站在服务器端的角度，获取信息为输入流


        BufferedInputStream bufferedReader = new BufferedInputStream(s.getInputStream());
//        byte[ ] col= new byte[1024];
//        int len=0;
//        while (-1!=(len=bufferedReader.read(col))) {
//            System.out.println(col);
//        }
      System.out.println(bufferedReader.read());
        //关闭流
        bufferedReader.close();

        //释放
        s.close();
        server.close();
    }
}
