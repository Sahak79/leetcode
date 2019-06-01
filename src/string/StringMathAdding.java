package string;

public class StringMathAdding {

    public static void main(String[] args) {
        adding("9998899", "1");
    }

    public static String add(String str1, String str2) {
        String result;
        char[] arrMax, arrMin;
        if(str1.length() > str2.length()) {
            arrMax = str1.toCharArray();
            arrMin = str2.toCharArray();
        } else {
            arrMax = str2.toCharArray();
            arrMin = str1.toCharArray();
        }
        StringBuilder builder = new StringBuilder();
        int diff = arrMax.length - arrMin.length;
        boolean isGT9 = false;
        for (int i = arrMin.length - 1; i >= 0; i--) {
            int i1 = Integer.parseInt("" + arrMax[i + diff]);
            int i2 = Integer.parseInt("" + arrMin[i]);
            int res = i1 + i2;
            if (res > 9) {
                if (isGT9) {
                    builder.append(res - 10 + 1);
                } else {
                    builder.append(res - 10);
                }
                isGT9 = true;
            } else {
                if (isGT9) {
                    if (res + 1 == 10) {
                        builder.append(0);
                        isGT9 = true;
                    } else {
                        builder.append(res + 1);
                        isGT9 = false;
                    }
                } else {
                    builder.append(res);
                }
            }
        }
        if (isGT9) {
            result = (new String(arrMax)).substring(0, diff - 1) +
                    (Integer.parseInt("" + arrMax[diff - 1]) + 1) +
                    builder.reverse().toString();
        } else {
            result = (new String(arrMax)).substring(0, diff) + builder.reverse().toString();
        }
        return result;
    }


    public static String add1(String str1, String str2) {
        String result = "";
        boolean isBothNegative = str1.charAt(0) == '-' && str2.charAt(0) == '-';
        boolean isBothPositive = str1.charAt(0) != '-' && str1.charAt(0) != '-';
        if (isBothPositive) {
            result = add(str1, str2);
        } else if (isBothNegative) {
            result = "-" + add(str1.substring(1), str2.substring(1));
        } else {
            String positive;
            String negative;
            if (str1.charAt(0) == '-') {
                positive = str2;
                negative = str1;
            } else {
                positive = str1;
                negative = str2;
            }
            result = subtract(positive, negative.substring(1));
        }
        return result;
    }

    public static String subtract(String positive, String negative) {
        String result = "";
        char[] arrMax, arrMin;
        if(positive.length() > negative.length()) {
            arrMax = positive.toCharArray();
            arrMin = negative.toCharArray();
        } else {
            arrMax = negative.toCharArray();
            arrMin = positive.toCharArray();
        }
        int diff = arrMax.length - arrMin.length;
        boolean isLT0 = false;
        for (int i = arrMax.length - 1; i >= 0; i--) {
            if (i - diff >= 0) {
                int i1 = Integer.parseInt("" + arrMin[i - diff]);
                int i2 = Integer.parseInt("" + (i - 1 < 0 ? '0' : arrMax[i - 1]) + arrMax[i]);
                int res = i2 - i1;
                if (res < 10) {
                    if (i - 1 > 0) {
                        arrMax[i - 1] = '0';
                    } else {
                        arrMax[i] = '0';
                    }
                    if (res < 0) {
                        res += 10;
                        isLT0 = true;
                    }
                    arrMax[i] = Character.forDigit(res, 10);
                } else {
                    isLT0 = false;
                    arrMax[i - 1] = Character.forDigit(res / 10, 10);;
                    arrMax[i] = Character.forDigit(res % 10, 10);
                }
            } else {
                if (isLT0 && i - 1 >= 0) {
                    int i2 = Integer.parseInt("" + arrMax[i - 1] + arrMax[i]);
                    i2 -= 1;
                    if (i2 < 0) {
                        i2 += 10;
                    }
                    arrMax[i - 1] = Character.forDigit(i2 / 10, 10);;
                    arrMax[i] = Character.forDigit(i2 % 10, 10);
                    if (i2 > 9) {
                        isLT0 = false;
                    }
                }
            }
            result = arrMax[0] == '0' ? (new String(arrMax)).substring(1) : new String(arrMax);
        }
        return result;
    }

    public static String adding(String str1, String str2) {
        String maxStr = str1.length() > str2.length() ? str1 : str2;
        String minStr = str1.length() > str2.length() ? str2 : str1;
        int diff = maxStr.length() - minStr.length();
        boolean isGT9 = false;
        StringBuilder builder = new StringBuilder();
        for (int i = maxStr.length() - 1; i >= 0; i--) {
            int i1 = Integer.parseInt(maxStr.substring(i, i + 1));
            if (i - diff >= 0) {
                int i2 = Integer.parseInt(minStr.substring(i - diff, i - diff + 1));
                int i3 = isGT9 ? i1 + i2 + 1 : i1 + i2;
                isGT9 = i3 > 9;
                builder.append(isGT9 ? i3 - 10 : i3);
            } else {
                if (isGT9) {
                    i1++;
                }
                if (i1 > 9) {
                    builder.append(i1 - 10);
                    isGT9 = true;
                } else {
                    builder.append(i1);
                    isGT9 = false;
                }
            }
        }
        if (isGT9) {
            builder.append("1");
        }
        return builder.reverse().toString();
    }
}
