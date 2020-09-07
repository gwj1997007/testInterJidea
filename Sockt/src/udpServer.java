import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description:
 * udp协议通信，服务器端进行接受
 * @Author: gwj
 * @CreateDate: 2019/5/1 15:46
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/1 15:46
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class udpServer {
    public static void main(String[] args) throws IOException {
        InetAddress ip =InetAddress.getLocalHost();
        //创建服务器端 DatagramSocket 类 + 指定端口
        DatagramSocket server =new DatagramSocket(7777);
        //准备接受容器 字节组 封装DatagramPacket
        byte[] container =new byte[1024];
        //封装成包 DatagramPacket
        DatagramPacket packet =new DatagramPacket(container,container.length);
        //接收数据
        server.receive(packet);
        //分析数据
        byte[] data =packet.getData();
        int len =packet.getLength();
        System.out.println(new String(data,0,len));
        //释放资源
        server.close();
    }


}
