package lintcode;

public class DigitCounts {
    public int digitCounts(int k, int n) {
        // write your code here

        int result = 0;
        int base = 1;
        while (n/base > 0) {

            int cur  = (n/base)%10;
            int low  = n-(n/base) * base;;
            int high = n/(base * 10);

            if (cur < k)
            {
                result += high*base;
            }
            else if (cur > k)
            {
                result += (high+1)*base;
            }
            else
            {
                result += high*base+low+1;
            }

            base *= 10;
        }

        return result;
    }


    public static void main(String[] args) {
        DigitCounts d=new DigitCounts();
        System.out.println(d.digitCounts(2,32)); d.digitCounts(2,32);
    }
}
