/**
 * @author:gwj
 * @date:2019/4/5
 * @description:PACKAGE_NAME
 * @version: 1.0
 */

public class Temp {
    public static void main(String[] args) {
        String[] inner = {

                "00",
                "00",
                "ab",
                "zz",
                "ZZ"
        };

        System.out.println(new Temp().getRemove(inner));
    }

    public int getRemove(String[] strings) {
        int[][] dump = new int[75][75];

        for (int i = 0; i < dump.length; i++) {
            for (int j = 0; j < dump[i].length; j++) {
                dump[i][j] = 0;
            }
        }
        int temp_first;
        int temp_second;
        for (String str : strings) {
            char[] temp = str.toLowerCase().toCharArray();
            temp_first = temp[0] - 48;
            temp_second = temp[1] - 48;
            dump[temp_first][temp_second]++;
        }
        int count = 0;
        for (int[] i : dump) {
            for (int j : i) {
                if (j > 1) {
                    count++;
                }
            }
        }
        return count;
    }
}


