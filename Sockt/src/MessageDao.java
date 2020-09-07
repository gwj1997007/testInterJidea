/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/5/1 18:51
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/1 18:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MessageDao {
    int id;
    String response;
    String receive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }
}
