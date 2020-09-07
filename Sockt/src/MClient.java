import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
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
public class MClient {
    public static void main(String[] args) throws IOException {


            Socket s = new Socket("127.0.0.1", 8888);

//            OutputStream os = s.getOutputStream();
//            DataOutputStream dos = new DataOutputStream(os);
            //开启自动刷新缓冲区
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//            InputStream is = s.getInputStream();
//            DataInputStream dis = new DataInputStream(is);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(s.getInputStream()));

            while(true){
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                bufferedWriter.write(str+"\n");
                bufferedWriter.flush();
//                s.shutdownOutput();

                String msg = bufferedReader.readLine()+"\t";
                //使用了回车符来保证另一端的readLine方法正常结束
//                bufferedWriter.write(str+"\r");
//                bufferedWriter.flush();
                System.out.println("收到服务端信息"+msg);
            }

    }
}
