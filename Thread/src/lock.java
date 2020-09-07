import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 接下来，借助Lock把MyStack修改为线程安全的类
 * @Author: gwj
 * @CreateDate: 2019/4/28 20:11
 * @UpdateUser: gwj
 * @UpdateDate: 2019/4/28 20:11
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class lock<T> {

    LinkedList<T> col = new LinkedList<>();
    //定义lock
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void push(T item) {
        //上锁
        try {
            lock.lock();
            while (col.size() >= 200) {
                condition.await();
            }
            condition.signalAll();
            col.add(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }

    public T pull() {
        try {
            lock.lock();
            while (col.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            return col.removeLast();
        } finally {
            lock.unlock();
        }

    }

    public T peek() {
        return col.getLast();
    }
}
