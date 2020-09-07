import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/**
 * @Description: 通过读取文件中的类信息创建该类的实例
 * @Author: gwj
 * @CreateDate: 2019/5/2 16:32
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/2 16:32
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class reflecttion {
    public static void main(String[] args) {
        //

        File file = new File("J:\\hero.config");

        //获取创建的类对象
        Hero h=getHero(file);
        System.out.println(h.getAge()+h.getName());
    }


    //读取文件中的类信息
    public static String getClassMsg(File file) throws IOException {
        //判空
        if (!file.exists()) {
            file.createNewFile();
        }
        //定义容器
        String str="";
        StringBuilder stringBuilder =new StringBuilder();
        //选择流
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            while (null != (str=bufferedReader.readLine())) {
                //读取
                stringBuilder.append(str);

            } System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return  new String(stringBuilder);
    }

    /**方法描述
     * 通过反射创建对象
     * @author qqg
     * @date 2019/5/3
     * @param
     *  file
     * @return
     */
    public static Hero getHero(File file){
            Hero hero = null;
        try {
            String className=getClassMsg(file);
            System.out.println("类名"+className);
            //使用反射加载类名
            Class clazz =Class.forName(className);
            System.out.println(clazz);
//            //加载类有参构造器
//            Constructor constructor =clazz.getDeclaredConstructor(String.class,Integer.class);
//            //创建对象
//            hero = (Hero) constructor.newInstance("ss",12);
            //加载无参构造器
            Constructor constructor =clazz.getConstructor();
            //创建对象
            hero = (Hero) constructor.newInstance();
            //创建完成
            hero.setAge(12);
            hero.setName("你好");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return hero;
    }





//    public static void main(String[] args) throws InterruptedException {
//        Hero h = getHero();
//        System.out.println(h);
//    }
//
//    public static Hero getHero() {
//
//        File f = new File("J:\\hero.config");
//
//        try (FileReader fr = new FileReader(f)) {
//            String className = null;
//            char[] all = new char[(int) f.length()];
//            fr.read(all);
//            className = new String(all);
//            Class clazz=Class.forName(className);
////            Constructor c= clazz.getConstructor();
//////            Hero h= (Hero) c.newInstance();
//            //加载类有参构造器
//            Constructor constructor =clazz.getDeclaredConstructor(String.class,Integer.class);
//            //创建对象
//            Hero h = (Hero) constructor.newInstance("ss",12);
//            return h;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
}
