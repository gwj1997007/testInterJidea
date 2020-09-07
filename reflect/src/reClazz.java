import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/5/3 17:24
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/3 17:24
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class reClazz {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //通过反射加载获取类
        Class clazz=Class.forName("Hero");
        System.out.println("类名："+clazz);
        //加载类构造器
        //加载所有构造器
        Constructor[] constructors=clazz.getDeclaredConstructors();
        System.out.println("所有构造器：");
        for (Constructor item:constructors
             ) {
            System.out.println(item);
        }
        //加载无参构造器
        Constructor constructor=clazz.getConstructor();
        //加载有参构造器
        Constructor constructor1=clazz.getDeclaredConstructor(String.class,int.class);//构造方法参数的类型
        //通过无参构造方法创建实例
        Hero h= (Hero) constructor.newInstance();
        System.out.println("无参对象："+h);
        //通过有参构造方法创建实例
        Hero h2= (Hero) constructor1.newInstance("你好",12);//构造方法参数
        System.out.println("有参对象："+h2);
        //获取类方法
        Method[] methods =clazz.getDeclaredMethods();//获取所有方法
        for (Method item:methods
             ) {
            System.out.println("方法："+item);
        }
        //获取方法
        Method method=clazz.getMethod("setName",String.class);//方法名，方法参数类型
        Method method1=clazz.getMethod("getName",null);//获取无参方法，方法名，无参
        //对象二h2调用method1方法
        System.out.println("h2调用getName方法");
        Object name=method1.invoke(h2);
        System.out.println(name);


        //获取类属性
        Field[] fields =clazz.getDeclaredFields();//获取所有属性
        for (Field item:fields
             ) {
            System.out.println("所有属性："+item);
        }
        //获取私有属性

        Field filed = clazz.getDeclaredField("name");//参数为属性名
        filed.setAccessible(true);//允许获得私有属性name
        filed.set(h2,"hello");//对象二修改name属性的值
        System.out.println(h2.getName());
        Field filed1 =clazz.getDeclaredField("age");
        filed1.setAccessible(true);//允许获得私有属性damage
    }

}
