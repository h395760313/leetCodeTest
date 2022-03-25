package com.algorithm.华为机试题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 *
 * 输入：
 *
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 *
 * 坐标之间以;分隔。
 *
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * 下面是一个简单的例子 如：
 *
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 *
 * 处理过程：
 *
 * 起点（0,0）
 *
 * +   A10   =  （-10,0）
 *
 * +   S20   =  (-10,-20)
 *
 * +   W10  =  (-10,-10)
 *
 * +   D30  =  (20,-10)
 *
 * +   x    =  无效
 *
 * +   A1A   =  无效
 *
 * +   B10A11   =  无效
 *
 * +  一个空 不影响
 *
 * +   A10  =  (10,-10)
 *
 * 结果 （10， -10）
 *
 * 数据范围：每组输入的字符串长度满足 1\le n \le 10000 \1≤n≤10000  ，坐标保证满足 -2^{31} \le x,y \le 2^{31}-1 \−2
 * 31
 *  ≤x,y≤2
 * 31
 *  −1  ，且数字部分仅含正数
 * 输入描述：
 * 一行字符串
 *
 * 输出描述：
 * 最终坐标，以逗号分隔
 *
 * 示例1
 * 输入：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出：
 * 10,-10
 *
 * 示例2
 * 输入：
 * ABC;AKL;DA1;
 * 输出：
 * 0,0
 */
public class HJ17_坐标移动 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strs = str.split(";");
        int x = 0;
        int y = 0;

        for (String s : strs) {
            if (s.isEmpty()) continue;
            String start = s.substring(0, 1);
            if (s.startsWith("A") || s.startsWith("S") || s.startsWith("D") || s.startsWith("W")) {
                String substring = s.substring(1);

                // 去除X
                if (substring.isEmpty()){
                    continue;
                }
                if (substring.length() > 3) continue;
                int num = 0;
                try {
                    num = Integer.parseInt(substring);
                }catch (Exception e){
                    continue;
                }
                switch (start) {
                    case "A" :
                        x -= num;
                        break;
                    case "S" :
                        y -= num;
                        break;
                    case "D" :
                        x += num;
                        break;
                    case "W" :
                        y += num;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("(" + x + "," + y + ")");
    }
}
