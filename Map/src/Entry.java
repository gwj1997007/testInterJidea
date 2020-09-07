/**
 * @author:gwj
 * @date:2019/4/7
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
//键值对
public class Entry {
    public String key;
    public Object value;

    public Entry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[key=" + key + ", value=" + value + "]";
    }
}

