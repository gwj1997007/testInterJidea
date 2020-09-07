/**
 * @Description: java类作用描述
 * @Author: gwj
 * @CreateDate: 2019/5/2 16:37
 * @UpdateUser: gwj
 * @UpdateDate: 2019/5/2 16:37
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Hero {
    private String name;
    private int age;
    static String copyright;


    public Hero() {
    }

    public Hero(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getCopyright() {
        return copyright;
    }

    public static void setCopyright(String copyright) {
        Hero.copyright = copyright;
    }

    static {
        System.out.println("初始化 copyright");

        copyright = "版权由Riot Games公司所有";
    }
}
