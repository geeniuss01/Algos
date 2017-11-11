package chef.bgnr;

import java.util.Scanner;

class Cookoff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().split("\\s+")[0]);
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(sc.nextLine().split("\\s+")[0]),cnt = 0;
            final boolean ar[] = new boolean[5];
            for (int i = 0; i < n; i++) {
                final int p;
                String d = sc.nextLine();
                if(cnt == 5) continue;
                switch (d) {
                    case "cakewalk": p = 0;break;
                    case "simple": p = 1;break;
                    case "easy": p = 2;break;
                    case "easy-medium":
                    case "medium": p=3; break;
                    case "medium-hard":
                    case "hard": p=4; break;
                    default:p=-1;
                }
                if (p != -1 && !ar[p]) {
                    ar[p]=true;
                    cnt++;
                }
            }
            System.out.println(cnt==5?"Yes":"No");
        }
    }
}
