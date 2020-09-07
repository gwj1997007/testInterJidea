import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Description: 把按钮监听中的按钮上的文字从“隐藏图片” 改为 "显示图片"。
 * <p>
 * 第一次点击的时候，会使得图片隐藏，第二次点击的时候，会使得图片显示，如此循环下去。
 * <p>
 * 一旦点击了"隐藏图片"，按钮上的文字就要变成“显示图片” 。。。 如此循环
 * <p>
 * 提示： 调用JButton对象的setText改变按钮上的文字
 * @Author: gwj
 * @CreateDate: 2019/4/29 18:26
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/29 18:26
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CreamChange {
    public static void main(String[] args) {
        //定义窗口容器
        JFrame jFrame =new JFrame("切换窗口");

        //设置窗口属性
        //窗口大小
        jFrame.setSize(400,400);

        jFrame.setLocation(580,200);

        jFrame.setLayout(null);

        //组件
        JLabel label=new JLabel();
        ImageIcon i = new ImageIcon("J:\\wamp\\wamp\\www\\22.jpg");
        label.setIcon(i);
        label.setBounds(20, 20, i.getIconWidth(), i.getIconHeight());

        //定义按钮
        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);

        b.addMouseListener(new MouseAdapter() {
            Boolean flag=true;
            @Override
            public void mouseClicked(MouseEvent e) {

//                super.mouseClicked(e);
//                if (flag) {
//                    b.setText("显示图片");
//                    //隐藏图片的方法
//                    label.setVisible(false);
//                    flag=false;
//                }else {
//                    b.setText("隐藏图片");
//                    //显示图片的方法
//                    label.setVisible(true);
//                    flag=true;
//                }
                //if else用三目运算符
                flag=!flag;
                label.setVisible(flag);
                b.setText(flag?"隐藏图片":"显示图片");

            }
        });

        //窗口属性
        jFrame.add(label);
        jFrame.add(b);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setVisible(true);

    }


}
