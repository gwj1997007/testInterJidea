import java.util.ArrayList;

/**
 * @author:gwj
 * @date:2019/4/5
 * @description:PACKAGE_NAME
 * @version: 1.0
 */
public class buckSort {
    //创建桶排序方法,参数为待排序的数组
    public static void buckSort(double[] s){
        //找出最大值和最小值
        double max=0;
        double min=0;
        for (int i=0;i<s.length;i++){
            if (s[i]>=max)
                max=s[i];
            if (s[i]<=min)
                min=s[i];
        }
        double gap=(max-min)/s.length+1;
        //计算桶的个数
        int count=(int)((max-min)/gap+1);
        //计算每个桶的范围
        double fanwei =Math.floor((max-min+1)/count);
        //创建装桶的容器
        ArrayList<Double>[] list=new ArrayList[count];
        for(int i=0;i<s.length;i++){
            //函数映射
            int index=(int)Math.floor((s[i]-min)/fanwei);
            if (list[index]==null) {
                //为每个桶创建容器存放加入进来的值
                list[index] = new ArrayList<Double>();
                list[index].add(s[i]);
            }else {//如果有数则进行排序
                for ( double nei:list[index]
                     ) {

                }

            }
        }
    }
}
