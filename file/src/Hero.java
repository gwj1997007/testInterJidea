import java.io.Serializable;

/**
 * @author:gwj
 * @date:2019/4/10
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class Hero implements Serializable{
    //表示这个类当前的版本，如果有了变化，比如新设计了属性，就应该修改这个版本号
    private static final long serialVersionUID = 1L;
    public int damage;
    public int blood;
    public String name;

    public Hero(int damage, int blood) {
        this.damage = damage;
        this.blood = blood;
    }

    @Override
    public String toString() {
        return "[damage=" + damage + ", blood=" + blood + "]";
    }

    //创建一个比较方法
    public static int compare(Hero h,Hero h1){
        return h.blood>=h1.blood?1:-1;
    }
}
