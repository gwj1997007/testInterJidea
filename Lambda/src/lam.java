/**
 * @author:gwj
 * @date:2019/4/10
 * @description:PACKAGE_NAME
 * @version: 1.0
 * <p>
 * 匿名类演变成lambda
 */

/**
 * 匿名类演变成lambda
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * 参数->方法体
 * compare只能辅助其他方法，例如是排序方法的一种规则，
 * 注意：需要将匿名类的方法体转换为一条return语句
 */
public class lam {
    public static void main(String[] args) {
        List<Hero> col = new ArrayList<>();
        col.add(new Hero(12, 22));
        col.add(new Hero(11, 23));
        col.add(new Hero(2, 3));
        //Collections.sort(col, (Hero o1, Hero o2) -> o1.blood >= o2.blood ? 1 : -1);
        //调用静态方法1  类名：：方法名
        // Collections.sort(col,lam::Compare);
        //调用静态方法2  参数->类名.方法名（参数）
        //Collections.sort(col,(h1,h2)->lam.Compare(h1,h2));
        //调用容器的方法1 参数->参数.方法（方法参数）
        //Collections.sort(col,(h1,h2)->h1.compare(h1,h2));
        //调用容器的方法2 类名：：方法名
        Collections.sort(col,Hero::compare);
        for (Hero h : col
                ) {
            System.out.println(h.toString());
        }
    }
        //静态方法
        public static  int Compare(Hero hero,Hero h){
            return hero.blood>=h.blood?1:-1;
    }


}





