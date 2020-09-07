import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Description:
 * 接收信息的线程
 * @Author: gwj
 * @CreateDate: 2019/5/2 15:13
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/2 15:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadReceive implements Runnable{
    private Socket socket;
    private JTextArea jTextArea;

    //构造方法

    public ThreadReceive(Socket socket,JTextArea jTextArea) {
        this.socket = socket;
        this.jTextArea=jTextArea;
    }

    @Override
    public void run() {
        //获取输入流
        try (DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())) {
            //读取数据
            while(true) {
                String msg = dataInputStream.readUTF();
                System.out.println("接收到信息"+msg);
                jTextArea.append(msg+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
