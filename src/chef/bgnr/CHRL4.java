package chef.bgnr;

import java.math.BigInteger;
import java.util.Scanner;

//  4 2  1 2 3 4
class CHRL4 {
    public static void main(String[] args) {
        BigInteger mod = BigInteger.valueOf(1000000007);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        BigInteger ar[] = new BigInteger[n];
        for (int i = 0; i < n; i++) ar[i] = sc.nextBigInteger(); // read array
        BigInteger res[] = new BigInteger[k+1];
        for (int i = 0; i <res.length; i++) res[i] = BigInteger.valueOf(Long.MAX_VALUE); // init array
        res[0]=ar[0];
        for (int i = 1; i < n; i++) {
            int min = 0;
            for (int j = 1; j < k; j++) if (res[j].compareTo(res[min]) < 1) min = j; // find min
            res[k] = (res[min].multiply(ar[i])).mod(mod);
            System.arraycopy(res, 1, res, 0, k); // shift left by 1;
            //System.out.println(Arrays.toString(res));
        }
        System.out.println(res[k]);
    }
}

// 0 1 2 3 4 5