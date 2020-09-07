import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description: 服务器端
 * @Author: gwj
 * @CreateDate: 2019/5/2 15:13
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/2 15:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class TaikServer {
    public static void main(String[] args) throws IOException {
        JFrame f = new JFrame();
        f.setTitle("server");

        f.setSize(400, 300);
        f.setLocation(100, 200);
        f.setLayout(null);

        JButton b = new JButton("send");
        b.setBounds(10, 10, 80, 30);
        f.add(b);

        final JTextField tf = new JTextField();
        tf.setBounds(10, 110, 80, 30);
        f.add(tf);

        final  JTextArea ta = new JTextArea();
        ta.setBounds(110,10, 200, 300);
        f.add(ta);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        //监听端口
        ServerSocket serverSocketLis =new ServerSocket(8888);
        System.out.println("listenning on port:8888");
        //创建Socket端接受
        Socket server =serverSocketLis.accept();

        //通信
        //输入
//        new Thread(new ThreadReceive(server,JTextArea)).start();
        new Thread(){
            @Override
            public void run() {
                //获取输入流
                try (DataInputStream dataInputStream = new DataInputStream(server.getInputStream())) {
                    /* 读取数据 */
                    while(true) {
                        String msg = dataInputStream.readUTF();
                        System.out.println("接收到信息"+msg);
                        ta.append(msg+"\r\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        //输出
//        new Thread(new ThreadSend(server)).start();

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String text = tf.getText();
                ta.append(text+"\r\n");

                try {
                    DataOutputStream dos = new DataOutputStream(
                            server.getOutputStream());
                    dos.writeUTF(text);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

}
