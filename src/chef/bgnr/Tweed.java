package chef.bgnr;

import java.util.Scanner;

class Tweed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            String who = sc.nextLine().trim();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) ar[i] = sc.nextInt();
            String win = (who.equals("Dee") && n == 1 && ar[0] % 2 == 0) ? "Dee" : "Dum";
            System.out.println(win);
        }

    }
}

