import java.util.LinkedList;

/**
 * @author:gwj
 * @date:2019/4/8
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class testMyHashMap {
    public static void main(String[] args) {
        MyHashMap map =new MyHashMap();

         map.put("t", "坦克");
         map.put("adc", "物理");
         map.put("apc", "魔法");
         map.put("t", "坦克2");

         System.out.println(map.get("t"));

         System.out.println(map);

        System.out.println("t:"+map.hashcode("t"));
        System.out.println("adc:"+map.hashcode("adc"));
        System.out.println("apc:"+map.hashcode("apc"));
        System.out.println("t:"+map.hashcode("t"));
//        System.out.println(map.hashcode("name=hero-5455"));

    }



}
