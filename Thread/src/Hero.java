import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: hero对象
 * @Author: gwj
 * @CreateDate: 2019/4/27 18:43
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/27 18:43
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Hero {
    //属性
    String name;
    int damage;
    //原子性操作
    //AtomicInteger blood = new AtomicInteger();//创建具有初始值 0 的新 AtomicInteger
    // 原子性操作本身是线程安全的，可以替换sychroinzed
    int blood;

    /**方法描述 恢复血量
     * @author gwj
     * @date 2019/4/27
     * @param
     * @return
     */
    public synchronized void recover(){
        //建立旗帜表示通知状态
        while(blood>=1000) {//还可以使用用AtomicInteger代替sychronized
            try {
                //如果不满足操作条件则等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //否则加血，加完血后通知其他线程
        blood=blood+1;
        //使用原子性操作
        //  blood.incrementAndGet();//以原子方式给当前值加一
        System.out.printf("%s 回血1点,增加血后，%s的血量是%d %n", name,name, blood);
        this.notify();
    }
    /**方法描述减血
     * @author qqg
     * @date 2019/4/27
     * @param
     * @return
     */
    public  synchronized void reduce(){
        //建立旗帜表示通知状态
       while(blood<=1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //减完血后通知其他线程
        blood=blood-1;
       //原子性操作
        //blood.decrementAndGet();//以原子方式给当前值减一
        System.out.printf("%s 减血1点,增加血后，%s的血量是%d %n", name,name,blood);
        this.notify();
    }
    /**方法描述  攻击其他
     * @author qqg
     * @date 2019/4/27
     * @param
     * @return
     */

    public void attack(Hero h){
        h.blood-=this.damage;
        //原子型操作
        // h.blood.addAndGet(0-damage);//以原子方式将给定值（括号中的值）与当前值相加。
        //判断死亡
        if (h.blood==0)
            System.out.println(h.name+"死亡");
    }
}
