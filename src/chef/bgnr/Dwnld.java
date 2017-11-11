package chef.bgnr;

import java.util.Scanner;

class Dwnld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(), k = sc.nextInt();
            int [] ti = new int[n], di = new int[n];
            for (int i = 0; i < n; i++) {
                ti[i]= sc.nextInt();
                di[i]= sc.nextInt();
            }
            int cnt =0;
            for (int i = 0, c = 0; i < n; i++) {
                int cc = c+ ti[i];
                if (c <= k && k < cc) {
                    cnt += ((cc - k) * di[i]);
                } else if (k < c) {
                    cnt += (ti[i] * di[i]);
                }
                c = cc;
            }
            System.out.println(cnt);
        }
    }
}
