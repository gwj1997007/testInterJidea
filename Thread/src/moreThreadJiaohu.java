/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/4/27$ 18:34$
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/27$ 18:34$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class moreThreadJiaohu {
    public static void main(String[] args) {

        final Hero b = new Hero();
        b.blood = 100;
        b.name = "b";
        b.damage = 1;

        for (int i = 0; i < 2; i++) {
            new recover(b).start();
        }

        for (int j = 0; j < 5; j++) {
            new reduce(b).start();
        }
    }

    //内部减血的线程类
    static class reduce extends Thread {
        private Hero hero;

        public reduce(Hero hero) {
            this.hero = hero;
        }

        //匿名创建两个线程

        @Override
        public void run() {
            while (true) {
                hero.reduce();
            }
        }


    }
//内部恢复血的线程类
    static class recover extends Thread {
        private Hero hero;

        public recover(Hero hero) {
            this.hero = hero;
        }


        @Override
        public void run() {
            while (true) {
                hero.recover();
            }
        }


    }


}
