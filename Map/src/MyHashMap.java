import java.util.LinkedList;
import java.util.List;


/**
 * @author:gwj
 * @date:2019/4/7
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class MyHashMap implements IHashMap {
    //定义linkedList数组存放每个位置的linkedList（每个位置用LinkedList存放多个键值对）
    LinkedList<Entry>[] col = new LinkedList[2000];

    /**
     * 设计put(String key,Object value)方法
     * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
     * 如果该位置没有数据，则把字符串和对象组合成键值对Entry，再创建一个LinkedList，把键值对，放进LinkedList中，最后把LinkedList 保存在这个位置。
     * 如果该位置有数据，一定是一个LinkedList,则把字符串和对象组合成键值对Entry，插入到LinkedList后面。
     *
     * @param key
     * @param value
     */
    @Override
    public void put(String key, Object value) {

        //首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,
        int hashcode = hashcode(key);
        //然后把这个hashcode作为下标，定位到数组的指定位置。
        LinkedList<Entry> list = null;
        //构建键值对
        Entry entry = new Entry(key, value);
        //判空
        if (col[hashcode] == null) {
            //如果该位置为空创建list
            list = new LinkedList<Entry>();
            list.add(entry);
            col[hashcode]=list;
        } else {
            //如果不为空
            //判断要插入的key与容器中的键有没有重复
            for (Entry entry1 : col[hashcode]) {
                if (entry1.key.equals(key)) {
                    //如果key相同，则替换掉原来的值
                    entry1.value = value;
                } else {
                    //如果key不同则添加
                    col[hashcode].add(entry);
                }
            }
        }
    }

    /**
     * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
     * 如果这个位置没有数据，则返回空
     * 如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空
     *
     * @param key
     * @return
     */
    @Override
    public Object get(String key) {
        //获取hashcode
        int hashcode = hashcode(key);
        //获取hashcode处的值lIinkedlist<entry>
        LinkedList<Entry> lists = col[hashcode];
        //如果该位置无值
        if (lists == null)
            return 0;
        Object result = null;
        for (Entry e : lists
                ) {
            //如果要查找的key等于该数组位置此处集合中的key,则返回其对应的值
            if (key.equals(e.key))
                result = e.value;
            //如果找到了就退出循环（循环会从头到尾不管找没找到要找的值），因为后边不会再有相同的key
            break;
        }
        return result;
    }

    /**
     * 如下是Java API提供的String的hashcode生成办法；
     * <p>
     * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     * <p>
     * <p>
     * s[0] 表示第一位字符
     * n表示字符串的长度
     * 本练习并不是要求去理解这个算法，而是自定义一个简单的hashcode算法，计算任意字符串的hashcode
     * 因为String类不能被重写，所以我们通过一个静态方法来返回一个String的hashcode
     * <p>
     * public static int hashcode(String)
     * <p>
     * <p>
     * 如果字符串长度是0，则返回0。
     * 否则： 获取每一位字符，转换成数字后，相加，最后乘以23
     * <p>
     * (s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.
     * <p>
     * <p>
     * 如果值超过了1999，则取2000的余数，保证落在0-1999之间。
     * 如果是负数，则取绝对值
     *
     * @param str
     * @return
     */
    public static int hashcode(String str) {
        //判空
        if (str.length() == 0)
            return 0;
        //先转化为数组
        char[] chars = str.toCharArray();
        //取出每一位
        int sum = 0;
        for (char item : chars
                ) {
            sum += item;
        }
        //hashcode
        int hashcode = sum * 23;
//        if (hashcode > 2000) {
//            hashcode = hashcode % 2000;
//        } else if (hashcode < 0) {
//            hashcode = 0 - hashcode;
//        }
        //简化上述hashcode计算语句
        hashcode = hashcode < 0 ? 0 - hashcode : hashcode;
        //保证落在2000之内
        hashcode = hashcode % 2000;
        return hashcode;
    }
    public String toString() {
        LinkedList<Entry> result = new LinkedList();

        for (LinkedList<Entry> linkedList : col) {
            if (null == linkedList)
                continue;
            result.addAll(linkedList);
        }
        return result.toString();
    }
}
