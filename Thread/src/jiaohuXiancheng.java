/**
 * @Description: 创建线程
 * @Author: gwj
 * @CreateDate: 2019/4/27$ 18:29$
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/27$ 18:29$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class jiaohuXiancheng  {
    public static void main(String[] args) {
        //创建两个Hero
        final Hero a=new Hero();
        a.blood=100;
        a.name="a";
        a.damage=1;
        final Hero b=new Hero();
        b.blood=999;
        b.name="b";
        b.damage=1;
        //a攻击b
        //a.attack(b);
        //匿名类创建一个恢复线程
        Thread recover=new Thread(){
            public void run() {
                while (true) {
                    //线程体
                    a.recover();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        //线程就绪
        recover.start();

        Thread reduce=new Thread(){
            public void run() {
                while (true) {
                    //线程体
                    a.reduce();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //线程就绪
        reduce.start();



    }






}
