import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/5/1 16:30
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/1 16:30
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        //客户端绑定端口
        Socket client =new Socket(InetAddress.getLocalHost(),8888);
        System.out.println(client);
        //发送信息
        //站在客户端的角度，是socket对象的输出流
        //节点流，字节流
        //定义发送的内容
        String content ="你好吗？";
        //发送数据，处理流包裹字节流，转换流
        BufferedOutputStream bufferedWriter=new BufferedOutputStream(client.getOutputStream());
        //写如信息
        bufferedWriter.write(content.getBytes());
        //强制刷新
        bufferedWriter.flush();
        //关闭流
        bufferedWriter.close();


        //释放
        client.close();
    }
}
