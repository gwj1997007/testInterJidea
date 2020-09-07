/**
 * @author:gwj
 * @date:2019/4/4
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class Hero {
    //姓名
    public String name;
    //血量
    public Double blood;

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, Double blood) {
        this.name = name;
        this.blood = blood;

    }
}
