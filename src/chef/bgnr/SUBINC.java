package chef.bgnr;


import java.math.BigInteger;
import java.util.Scanner;


class SUBINC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            if(N<1) {
                System.out.println(0);
                continue;
            }
            long cnt = 1;
            BigInteger prv = sc.nextBigInteger(), sum = BigInteger.valueOf(0L);
            for (int i = 1; i < N; i++) {
                BigInteger cur = sc.nextBigInteger();
                if (cur.compareTo(prv)>=0) {
                    cnt++;
                } else {
                    sum = sum.add(BigInteger.valueOf((cnt * (cnt + 1)) / 2));
                    cnt = 1;
                }
                prv = cur;
            }
            sum = sum.add(BigInteger.valueOf((cnt * (cnt + 1)) / 2));
            System.out.println(sum);
        }
    }
}

/*

[1] [1]
[1,2] len1: [1][2], len2: [1 2]
[1 2 3] len1: [1][2][3], len2: [1 2][2 3], len3: [1 2 3]

1234
2345
3456
4567

4-1+1 + 4-2+1 + 4-3+1 + 4-4+1
5(4) - 5(4)/2

 */