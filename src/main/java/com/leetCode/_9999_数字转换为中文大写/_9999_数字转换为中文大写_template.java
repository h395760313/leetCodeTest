package com.leetCode._9999_数字转换为中文大写;

import org.junit.Test;


/**
 * 将数字转换为中文大写
 * 例
 * 1002  ->  一千零二
 * 5200  ->  五千二百
 */
public class _9999_数字转换为中文大写_template {

    public String changeNumberToChineseUpper(long number) {
        String[] arr0 = new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        String[] arr1 = new String[]{"","拾","佰","仟"};
        String[] arr2 = new String[]{"万","亿","万亿","亿亿"};
        String str = String.valueOf(number);
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            int n = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (n == 0){
                if (i + 1 < len && str.charAt(i + 1) != '0' && (len - i - 1 )% 4 != 0){
                    sb.append(arr0[0]);
                    flag = true;
                }
            }else {
                sb.append(arr0[n]).append(arr1[(len - i - 1 )% 4]);
                flag = true;
            }
            if ((len - i - 1 ) % 4 == 0 && flag && (len - i - 1 ) != 0){
                sb.append(arr2[(len - i ) / 4 - 1]);
                flag = false;
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(changeNumberToChineseUpper(Long.parseLong("1000000000000000001")));
    }






    /**
     * 第一级别段数
     */
    final static String[] units1 = {"", "拾", "佰", "仟",};
    /**
     * 第二级别段数
     */
    final static String[] units2 = {"", "万", "亿", "万亿"};
    final static String[] numEnum = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒","捌", "玖"};
    public static void main(String[] args) {
        int num = 1000000001;
        System.out.println(numToChinese(num));
    }

    public static String numToChinese(int num) {
        char[] numChar = String.valueOf(num).toCharArray();
        StringBuffer sb = new StringBuffer("");
        int length = numChar.length;
        for (int i = 0; i < length; i++) {
            int mod = (length - 1 - i) % 4;
            int n = Integer.parseInt(numChar[i] + "");
            if (n == 0) {
                if (i + 1 < length && numChar[i + 1] != '0' && mod != 0) {
                    sb.append(numEnum[0]);
                }
            } else {
                sb.append(numEnum[n]).append(units1[mod]);
            }

            /**
             * 补上第二级别段数
             */
            if (mod == 0) {
                sb.append(units2[(length - i) / 4]);
            }
        }
        return sb.toString();
    }
}
