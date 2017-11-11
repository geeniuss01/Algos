package etc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Arys {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(nextGreater(new int[]{4,5,2,25})));
//        System.out.println(Arrays.toString(nextGreater(new int[]{13,7,6,12})));

//        System.out.println(getJumbledNumsLessThan(43));


//        ArrayList<Integer> ls = new ArrayList<>();
//        ls.add(1);
//        System.out.println(recurSpiral(A2D_AR, 0, 0, 0, ls));

        System.out.println(allPrimesBelow(31));

    }


    private static boolean isPrime(int n) {
        if(n<2) return false;
        if(n == 2 || n==3) return true;
        if(n%2 == 0 || n%3 ==0) return false;
        int i = 5;
        int sq = new Double(Math.sqrt(n)).intValue()+1;
        for(;i<sq;i=i+6)
            if(n%i==0 || n%(i+2)==0) return false;
        return true;
    }

    private static ArrayList<Integer> allPrimesBelow(int N) {
        boolean[] bools = new boolean[N+1];
        for(int i=0;i<bools.length;i++) bools[i]=true;
        int sq = new Double(Math.sqrt(N)).intValue()+1;
        for(int i=2;i<sq;i++) {
            int isq= i*i;
            if (bools[i]) {
                for(int j=isq;j<N;j=j+i) bools[j] = false;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 2; j < N; j++) {
            if(bools[j]) list.add(j);
        }
        return list;
    }

    /**
     * http://www.geeksforgeeks.org/next-greater-element/
     * @param a
     * @return
     */
    private static int[] nextGreater(int[] a) {
        int[] op = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < a.length; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                op[stack.pop()] = a[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            op[stack.pop()] = -1;
        }
        return op;
    }

    /**
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98]
     * @param N
     * @return
     */
    private static ArrayList<Integer> getJumbledNumsOfDigits(int N) {
        ArrayList<Integer> jum = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1; i<10;i++) q.addLast(i);
        while (!q.isEmpty()) {
            if(q.peekFirst().toString().length() == N) break;
            Integer num = q.removeFirst();
            jum.add(num);
            int ld = num%10;
            if(ld > 0) q.addLast(num * 10 + ld - 1);
            if(ld < 9 ) q.addLast(num * 10 + ld + 1);
        }
        jum.addAll(q);
        return jum;
    }
    private static ArrayList<Integer> getJumbledNumsLessThan(int N) {
        ArrayList<Integer> jum = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1; i<10;i++) q.addLast(i);
        while (!q.isEmpty()) {
            if(q.peekFirst() >= N) break;
            Integer num = q.removeFirst();
            jum.add(num);
            int ld = num%10;
            if(ld > 0) q.addLast(num * 10 + ld - 1);
            if(ld < 9 ) q.addLast(num * 10 + ld + 1);
        }
        return jum;
    }

    private static final int[][] A2D_AR = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static ArrayList<Integer> recurSpiral(int[][] ar, int curx, int cury, int pos_ind, ArrayList<Integer> ls) {
        //System.out.println(curx + "," + cury + "," + pos_ind + ", " + ls);
        if (ls.size() == ar.length * ar[0].length) {
            return ls;
        }
        int nxtx = curx + DIRECTIONS[pos_ind][0];
        int nxty = cury + DIRECTIONS[pos_ind][1];
        if (nxtx < ar.length && nxty < ar[0].length && nxtx >= 0 && nxty >= 0) {
            int e = ar[nxtx][nxty];
            if (!ls.contains(e)) {
                ls.add(e);
                return recurSpiral(ar, nxtx, nxty, pos_ind, ls);
            } else {
                return recurSpiral(ar, curx, cury, (pos_ind + 1) % 4, ls);
            }
        } else {
            return recurSpiral(ar, curx, cury, (pos_ind + 1) % 4, ls);
        }
    }
    
    public void naaam() {
		System.out.println("heyyy");
		
	}

}
