package chef.bgnr;

import java.util.Scanner;

class ICPC16B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int gt1=0, mnsoneCnt=0, oneCnt=0;
            for (int i = 0; i < n; i++) {
                int e = sc.nextInt();
                if(e == -1) mnsoneCnt ++;
                if(e == 1) oneCnt ++;
                if (e > 1 || e < -1) gt1++;
            }
            switch (mnsoneCnt) {
                case 0:
                    System.out.println(gt1 < 2 ? "yes" : "no");break;
                case 1:
                    System.out.println(gt1 == 0 ? "yes" : "no");break;
                default: // > 1
                    System.out.println((gt1 == 0 && oneCnt > 0) ? "yes" : "no");break;
            }
        }
    }
}
