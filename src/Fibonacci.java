public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(getCount(2));
    }

    private static int getCount(int i) {
        return count(1, 1, 2, i);
    }

    private static int count(int i, int i1, int i2, int i3) {
        if(i3 == 2 || i3 == 1) {
            return 1;
        }
        if(i3-- == 3) {
            return i2;
        }
        i2 += i1;
        int tmp = i1;
        i1 += i;
        i = tmp;
        return count(i, i1, i2, i3);
    }


}
