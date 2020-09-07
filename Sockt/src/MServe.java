import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/5/1 21:46
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/1 21:46
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MServe {
    public static void main(String[] args) {
        try {

            ServerSocket ss = new ServerSocket(8888);

            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();

            InputStream is = s.getInputStream();
//            DataInputStream dis = new DataInputStream(is);
            OutputStream os = s.getOutputStream();
//            DataOutputStream dos = new DataOutputStream(os);
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os));
//            InputStream is = s.getInputStream();
//            DataInputStream dis = new DataInputStream(is);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));

            while (true) {
                String msg = bufferedReader.readLine();//readline读取无法判断行所以无法判断有没有写完，必须在写的时候分行
                System.out.println("收到客户端信息"+msg);

                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                bufferedWriter.write(str+"\n");
                bufferedWriter.flush();
                //因为我关闭了输出流，所以另一端的readLine方法才正常结束了
//                s.shutdownOutput();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
