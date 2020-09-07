import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description: 发送线程
 * @Author: gwj
 * @CreateDate: 2019/5/2 15:13
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/2 15:13
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ThreadSend implements Runnable {
    private Socket socket;


    //构造方法

    public ThreadSend(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //需要Socket对象
        //输出流使用数据流(处理流)

        try (DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                Scanner input = new Scanner(System.in);
                String msg = input.nextLine();
                //输出信息
                dataOutputStream.writeUTF(msg);
                //强制刷新
                dataOutputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
