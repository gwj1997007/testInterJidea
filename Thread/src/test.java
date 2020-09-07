/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/4/28 11:29
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/28 11:29
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        PraticeThread<Character> stack =new PraticeThread<>();
        stack.push('c');
        stack.push('b');
        while (true){
            char c =stack.pull();
            System.out.println(c);
        }

    }

}
