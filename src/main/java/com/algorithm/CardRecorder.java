package com.algorithm;

import java.util.Scanner;

public class CardRecorder {
    static volatile int[][] cards = new int[15][2];
    static volatile int[][] clone = new int[15][2];

    public static void main(String[] args) {

        for (int i = 0; i < cards.length; i++) {
            cards[i][0] = i + 1;
            clone[i][0] = i + 1;
            if (i <= 12) {
                cards[i][1] = 4;
                clone[i][1] = 4;
            } else {
                cards[i][1] = 1;
                clone[i][1] = 1;
            }
        }

        new Thread(() -> {
            Scanner s = new Scanner(System.in);
            boolean flag = true;
            while (flag) {
                String str = s.next().toUpperCase();
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    Integer cc = i + 1;
                    switch (chars[i]) {
                        case '1':
                            if (i != chars.length - 1 && chars[i + 1] == '0') {
                                cc = 9;
                                i++;
                            } else cc = 0;
                            break;
                        case '2':
                            cc = 1;
                            break;
                        case '3':
                            cc = 2;
                            break;
                        case '4':
                            cc = 3;
                            break;
                        case '5':
                            cc = 4;
                            break;
                        case '6':
                            cc = 5;
                            break;
                        case '7':
                            cc = 6;
                            break;
                        case '8':
                            cc = 7;
                            break;
                        case '9':
                            cc = 8;
                            break;
                        case 'T':
                            cc = 9;
                            break;
                        case 'J':
                            cc = 10;
                            break;
                        case 'Q':
                            cc = 11;
                            break;
                        case 'K':
                            cc = 12;
                            break;
                        case 'S':
                            cc = 13;
                            break;
                        case 'X':
                            cc = 14;
                            break;
                        case 'A':
                            cc = 0;
                            break;
                        case 'R':
                            for (int j = 0; j < cards.length; j++) {
                                cards[j][1] = clone[j][1];
                            }
                            cc = null;
                            System.out.println("===开始下一局===");
                            break;
                        case 'E':
                            flag = false;
                            break;
                        default:
                            break;
                    }
                    if (cc != null) {
                        cards[cc][1]--;
                    }
                }

                for (int i = 0; i < cards.length; i++) {
                    if (i < 9) {
                        System.out.print("[" + cards[i][0] + "]: " + cards[i][1] + "\t");
                    } else {
                        switch (i) {
                            case 9:
                                System.out.print("[10]: " + cards[i][1] + "\t");
                                break;
                            case 10:
                                System.out.print("[J]: " + cards[i][1] + "\t");
                                break;
                            case 11:
                                System.out.print("[Q]: " + cards[i][1] + "\t");
                                break;
                            case 12:
                                System.out.print("[K]: " + cards[i][1] + "\t");
                                break;
                            case 13:
                                System.out.print("[S]: " + cards[i][1] + "\t");
                                break;
                            case 14:
                                System.out.print("[X]: " + cards[i][1] + "\t");
                                break;
                            default:
                                break;
                        }
                    }
                    if (i == 9) {
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }).start();


    }
}
