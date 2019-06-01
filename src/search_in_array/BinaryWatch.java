package search_in_array;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(3));
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> options = new ArrayList<>();
        // 10 : 4 + 6
        char[] buf = new char[8];
        // count of 1s and count 0s.
        populateOptions(num, 8 - num, buf, 0, options);
        List<String> res = new ArrayList<>();
        for (String s: options) {
            s = convertToTime(s);
            if (s != null) {
                res.add(s);
            }
        }
        return res;
    }

    private static void populateOptions(int count1, int count0, char[] buf, int i, List<String> options) {
        if (i == buf.length) {
            options.add(new String(buf));
            return;
        }
        if (count1 > 0) {
            buf[i] = '1';
            populateOptions(count1 - 1, count0, buf, i + 1, options);
        }
        if (count0 > 0) {
            buf[i] = '0';
            populateOptions(count1, count0 - 1, buf, i + 1, options);
        }
    }

    private static int binaryValue(String s) {
        int power = 1, val = 0;
        for (char c : s.toCharArray()) {
            val += (c == '1' ? power : 0);
            power = power << 1;
        }
        return val;
    }

    private static String convertToTime(String s) {
        int hour = binaryValue(s.substring(0, 4));
        int minute = binaryValue(s.substring(4));
        if (hour < 12 && minute < 60) {
            String hourStr = String.valueOf(hour);
            String minStr = String.valueOf(minute);
            if (minute < 10) {
                minStr = "0" + minStr;
            }
            return hourStr + ":" + minStr;
        }
        return null;
    }
}
