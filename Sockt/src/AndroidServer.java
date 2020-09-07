import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

/**
 * @Description: 首先创建一个数据库android(android现在是手机操作系统 ， 其本意是机器人的意思)
 * <p>
 * 然后创建一个表dictionary，字段：
 * id int
 * receive varchar(100)
 * response varchar(100)
 * <p>
 * receive 表示受到的信息
 * response 表示回应的信息
 * <p>
 * 在这个表里准备一些数据：
 * 你好 -> 好你妹！
 * 你叫什么 -> 你想泡我啊？
 * 打你哦 -> 来啊，来打我啊，不打有点挫
 * 等等
 * 等等
 * <p>
 * 开发一个程序，当从scanner读取到消息，发给Server服务端，服务端用这个消息到表dictionary中找到对应的相应，返回出去。 看上去就像在自动回应一样。
 * 如果一个recieve有多条response，则随机返回一条
 * @Author: gwj
 * @CreateDate: 2019/5/1 18:26
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/1 18:26
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AndroidServer {

    public static void main(String[] args) throws IOException {

        //服务器监听端口
        ServerSocket serverListener = new ServerSocket(7777);
        //接受客户端
        Socket server = serverListener.accept();
        System.out.println(server);
        //通信，
        // 有输入，有输出,选择流，字符流需要转换流辅助
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
        while (true) {
            String get = "";
            get = bufferedReader.readLine();
//          根据接受的数据来选择响应
            if (null != get) {
                System.out.println("服务端获取到值" + get);
            }
//            bufferedReader.close();
//            ArrayList<MessageDao>  g =response(get);
            String re=response(get);
//            System.out.println("响应"+re);
            //响应
            bufferedWriter.write(re+"\n");
            //强制刷新
            bufferedWriter.flush();

            //关闭流

//            bufferedWriter.close();


//            释放
//            server.close();
//            serverListener.close();
        }

    }

    /**
     * 方法描述
     * 连接数据库根据输入的值获取响应的值
     *
     * @param
     * @return
     * @author qqg
     * @date 2019/5/1
     */
    public static String response(String get) {

        ArrayList<MessageDao> m =new ArrayList<>();

        String output = "";
        //需要用到数据库
        //用jdbc
        //定义参数
        String url = "jdbc:mysql://localhost:3306/android?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
        String passwd = "123456";
        String username = "root";
        //注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //sql语句
        String sql = "select response from android where receive=?";
        //创建statement
        //获取连接
        try (Connection conn = DriverManager.getConnection(url, username, passwd);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            //给语句参数赋值
            statement.setString(1, get);
            //处理数据
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getString(3));
//                System.out.println("链接数据库");
//                MessageDao messageDao = new MessageDao();
//                messageDao.setId(resultSet.getInt(1));
//                messageDao.setResponse(resultSet.getString(3));
//                messageDao.setReceive(get);
                output=resultSet.getString(1);
//                m.add(messageDao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }
}
