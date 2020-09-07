import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;


/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/5/1 15:46
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/1 15:46
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class udpClient {
    public static void main(String[] args) throws IOException {
        //创建客户端+端口
        DatagramSocket client=new DatagramSocket(6666);
        //准备数据
        String msg="udp";
        byte[] data=msg.getBytes();
        //打包（发送的地点及端口）
        DatagramPacket datagramPacket=new DatagramPacket(data,data.length,InetAddress.getLocalHost(),7777);
        //发送
        client.send(datagramPacket);
        //释放
        client.close();
    }

}
