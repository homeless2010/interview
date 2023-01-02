package com.cjcui;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 排序字段
 */
enum SortField {
    VALUE("Value"), NAME("Name");
    private String field;

    SortField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}

/**
 * 排序类型
 */
enum SortType {
    DESC("DESC"), ASC("ASC");
    private String type;

    SortType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}


/**
 * @author cjcui
 */
public class Chart {
    private static final String[] BORDER = {unicode2String("\\u250c"), unicode2String("\\u2510"), unicode2String("\\u2514"), unicode2String("\\u2518")};
    private static final String[] HORIZONTAL_VERTICAL = {unicode2String("\\u2500"), unicode2String("\\u2502")};
    private static final String[] CROSS = {unicode2String("\\u251c"), unicode2String("\\u2524"), unicode2String("\\u252c"), unicode2String("\\u2534"), unicode2String("\\u253c")};
    private static final String PILLAR = unicode2String("\\u2588");
    private static final String SPACE = unicode2String("\\u0020");

    private static final int MAX_LENGTH = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        Integer row = Integer.parseInt(scanner.nextLine());
        String sort = scanner.nextLine();
        String[] data = new String[row];
        for (int i = 0; i < row; i++) {
            data[i] = scanner.nextLine();
        }
        scanner.close();
        new Chart().chart(row, sort, data);
    }

    /**
     * @param unicode
     * @return
     */
    public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int data = Integer.parseInt(hex[i], 16);
            string.append((char) data);
        }
        return string.toString();
    }

    public void chart(int row, String sort, String[] data) {
        //name最大长度
        int namemaxLength = 0;
        //value最大
        int maxValue = 0;
        for (int i = 0; i < data.length; i++) {
            namemaxLength = Math.max(namemaxLength, data[i].split(SPACE)[0].length());
            maxValue = Math.max(maxValue, Integer.parseInt(data[i].split(SPACE)[1]));
        }
        //排序
        String[] sorts = sort.split(SPACE);
        if (SortField.VALUE.getField().equals(sorts[0])) {
            if (SortType.DESC.getType().equals(sorts[1])) {
                Arrays.sort(data, (d1, d2) -> Integer.parseInt(d2.split(SPACE)[1]) - Integer.parseInt(d1.split(SPACE)[1]));
            } else {
                Arrays.sort(data, Comparator.comparingInt(d -> Integer.parseInt(d.split(SPACE)[1])));
            }
        } else {
            if (SortType.DESC.getType().equals(sorts[1])) {
                Arrays.sort(data, (d1, d2) -> d2.split(SPACE)[0].length() - d1.split(SPACE)[0].length());
            } else {
                Arrays.sort(data, Comparator.comparingInt(d -> d.split(SPACE)[0].length()));
            }
        }
        //行边框
        for (int i = 0; i < row + 1; i++) {
            if (i == 0) {
                System.out.print(BORDER[0]);
            } else if (i == row) {
                System.out.print(BORDER[2]);
            } else {
                System.out.print(CROSS[0]);
            }
            for (int j = 0; j < 20 + namemaxLength + 1; j++) {
                if (j == namemaxLength && (i > 0 && i < row)) {
                    System.out.print(CROSS[4]);
                } else if (j == namemaxLength && (i == 0)) {
                    System.out.print(CROSS[2]);
                } else if (j == namemaxLength && (i == row)) {
                    System.out.print(CROSS[3]);
                } else {
                    System.out.print(HORIZONTAL_VERTICAL[0]);
                }
            }
            if (i == 0) {
                System.out.print(BORDER[1]);
            } else if (i == 3) {
                System.out.print(BORDER[3]);
            } else {
                System.out.print(CROSS[1]);
            }
            //行内容
            if (i < row) {
                System.out.println();
                System.out.print(HORIZONTAL_VERTICAL[1]);
                for (int j = 0; j < MAX_LENGTH + namemaxLength + 1; j++) {
                    if (j == namemaxLength) {
                        System.out.print(HORIZONTAL_VERTICAL[1]);
                    } else {
                        String name = data[i].split(SPACE)[0];
                        if (j < namemaxLength - name.length()) {
                            System.out.print(SPACE);
                        } else if (j < namemaxLength) {
                            //打印name
                            System.out.print(name.charAt(j - (namemaxLength - name.length())));
                        } else {
                            //打印柱
                            if ((j - namemaxLength) <= (Integer.parseInt(data[i].split(SPACE)[1]) * 20 / maxValue)) {
                                System.out.print(PILLAR);
                            } else {
                                System.out.print(SPACE);
                            }
                        }
                    }
                }
                System.out.println(HORIZONTAL_VERTICAL[1]);
            }
        }
    }
}
